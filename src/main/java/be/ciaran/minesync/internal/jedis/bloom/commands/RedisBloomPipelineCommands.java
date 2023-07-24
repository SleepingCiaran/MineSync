package be.ciaran.minesync.internal.jedis.jedis.bloom.commands;

public interface RedisBloomPipelineCommands extends BloomFilterPipelineCommands,
    CuckooFilterPipelineCommands, CountMinSketchPipelineCommands, TopKFilterPipelineCommands,
    TDigestSketchPipelineCommands {

}
