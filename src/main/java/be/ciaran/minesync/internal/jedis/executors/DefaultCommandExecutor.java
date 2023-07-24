package be.ciaran.minesync.internal.jedis.jedis.executors;

import be.ciaran.minesync.internal.jedis.CommandObject;
import be.ciaran.minesync.internal.jedis.Connection;
import be.ciaran.minesync.internal.jedis.util.IOUtils;
import be.ciaran.minesync.internal.jedis.providers.ConnectionProvider;

public class DefaultCommandExecutor implements CommandExecutor {

  protected final ConnectionProvider provider;

  public DefaultCommandExecutor(ConnectionProvider provider) {
    this.provider = provider;
  }

  @Override
  public void close() {
    IOUtils.closeQuietly(this.provider);
  }

  @Override
  public final <T> T executeCommand(CommandObject<T> commandObject) {
    try (Connection connection = provider.getConnection(commandObject.getArguments())) {
      return connection.executeCommand(commandObject);
    }
  }
}
