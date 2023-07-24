package be.ciaran.minesync;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import redis.clients.jedis.*;

public final class MineSync extends JavaPlugin implements Listener {
    private JedisPool jedisPool;
    private ChannelSubscriber channelSubscriber;

    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        String hostname = getConfig().getString("hostname");
        Integer port = getConfig().getInt("port");
        String username = getConfig().getString("username");
        String password = getConfig().getString("password");
        String channel = getConfig().getString("channel");
        Integer timeout = getConfig().getInt("timeout");
        jedisPool = new JedisPool(new JedisPoolConfig(), hostname, port, timeout, username, password);
        (new BukkitRunnable() {
            @Override
            public void run() {
                channelSubscriber = new ChannelSubscriber();
                Jedis jedis = jedisPool.getResource();
                try {
                    jedis.subscribe(channelSubscriber, channel);
                } catch (Exception err) {
                    err.printStackTrace();
                    jedisPool.returnBrokenResource(jedis);
                    getLogger().severe("Unable to connect to Redis server.");
                    return;
                }
                jedisPool.returnResource(jedis);
            }
        }).runTaskAsynchronously(this);
    }

    @Override
    public void onDisable() {
        channelSubscriber.unsubscribe();
        jedisPool.destroy();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("minesync")) {
            String servername = getConfig().getString("servername");
            if (sender instanceof Player) {
                sender.sendMessage(ChatColor.RED + "This command is only executable by the console.");
                return false;
            }
            if (args.length <= 1) return false;
            String dstServer = args[0];
            String arguments = String.join(" ", args);
            arguments = arguments.replace(dstServer + " ", "");
            if (arguments.startsWith("/"))
                arguments = arguments.substring(1);
            String cmdString = arguments;
            cmdString = servername + "|@|" + dstServer + "|@|" + cmdString;
            final String finalCmdString = cmdString;
            (new BukkitRunnable() {
                @Override
                public void run() {
                    Jedis jedis = jedisPool.getResource();
                    try {
                        jedis.publish(getConfig().getString("channel"), finalCmdString);
                    } catch (Exception err) {
                        jedisPool.returnBrokenResource(jedis);
                    }
                   jedisPool.returnResource(jedis);
                }
            }).runTaskAsynchronously(this);
            sender.sendMessage(ChatColor.GREEN + "Sent \"/" + arguments + "\" to " + dstServer + ".");
            return true;
        }
        return false;
    }

    public class ChannelSubscriber extends JedisPubSub {
        @Override
        public void onMessage(String channel, final String message) {
            String[] sections = message.split("\\|@\\|");
            String srcServer = sections[0];
            String dstServer = sections[1].toLowerCase();
            String execCmd = sections[2];
            if (dstServer.equals(getConfig().getString("servername")) || dstServer.equals("all")) {
                (new BukkitRunnable() {
                    @Override
                    public void run() {
                        getLogger().info("Executing command \"/" + execCmd + "\" received from " + srcServer);
                        getServer().dispatchCommand(getServer().getConsoleSender(), execCmd);
                    }
                }).runTask(MineSync.plugin);
            }
        }

        @Override
        public void onPMessage(String pattern, String channel, String message) {

        }

        @Override
        public void onSubscribe(String channel, int subscribedChannels) {

        }

        @Override
        public void onUnsubscribe(String channel, int subscribedChannels) {

        }

        @Override
        public void onPUnsubscribe(String pattern, int subscribedChannels) {

        }

        @Override
        public void onPSubscribe(String pattern, int subscribedChannels) {

        }
    }
}
