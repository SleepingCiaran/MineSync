package be.ciaran.minesync.internal.jedis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import be.ciaran.minesync.internal.jedis.Response;
import be.ciaran.minesync.internal.jedis.bloom.BFInsertParams;
import be.ciaran.minesync.internal.jedis.bloom.BFReserveParams;

public interface BloomFilterPipelineCommands {

  Response<String> bfReserve(String key, double errorRate, long capacity);

  Response<String> bfReserve(String key, double errorRate, long capacity, BFReserveParams reserveParams);

  Response<Boolean> bfAdd(String key, String item);

  Response<List<Boolean>> bfMAdd(String key, String... items);

  Response<List<Boolean>> bfInsert(String key, String... items);

  Response<List<Boolean>> bfInsert(String key, BFInsertParams insertParams, String... items);

  Response<Boolean> bfExists(String key, String item);

  Response<List<Boolean>> bfMExists(String key, String... items);

  Response<Map.Entry<Long, byte[]>> bfScanDump(String key, long iterator);

  Response<String> bfLoadChunk(String key, long iterator, byte[] data);

  Response<Map<String, Object>> bfInfo(String key);
}
