package be.ciaran.minesync.internal.jedis.jedis.commands;

import be.ciaran.minesync.internal.jedis.bloom.commands.RedisBloomCommands;
import be.ciaran.minesync.internal.jedis.graph.RedisGraphCommands;
import be.ciaran.minesync.internal.jedis.json.RedisJsonCommands;
import be.ciaran.minesync.internal.jedis.search.RediSearchCommands;
import be.ciaran.minesync.internal.jedis.timeseries.RedisTimeSeriesCommands;

public interface RedisModuleCommands extends
    RediSearchCommands,
    RedisJsonCommands,
    RedisTimeSeriesCommands,
    RedisBloomCommands,
    RedisGraphCommands {

}
