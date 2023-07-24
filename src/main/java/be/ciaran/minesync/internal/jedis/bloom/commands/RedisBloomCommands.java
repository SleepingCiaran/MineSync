package be.ciaran.minesync.internal.jedis.jedis.bloom.commands;

public interface RedisBloomCommands extends BloomFilterCommands, CuckooFilterCommands,
    CountMinSketchCommands, TopKFilterCommands, TDigestSketchCommands {

}
