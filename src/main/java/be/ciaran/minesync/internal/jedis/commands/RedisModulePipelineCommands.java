package be.ciaran.minesync.internal.jedis.jedis.commands;

import be.ciaran.minesync.internal.jedis.bloom.commands.RedisBloomPipelineCommands;
import be.ciaran.minesync.internal.jedis.graph.RedisGraphPipelineCommands;
import be.ciaran.minesync.internal.jedis.json.RedisJsonPipelineCommands;
import be.ciaran.minesync.internal.jedis.search.RediSearchPipelineCommands;
import be.ciaran.minesync.internal.jedis.timeseries.RedisTimeSeriesPipelineCommands;

public interface RedisModulePipelineCommands extends
    RediSearchPipelineCommands,
    RedisJsonPipelineCommands,
    RedisTimeSeriesPipelineCommands,
    RedisBloomPipelineCommands,
    RedisGraphPipelineCommands {

}
