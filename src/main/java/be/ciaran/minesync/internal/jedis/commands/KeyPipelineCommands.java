package be.ciaran.minesync.internal.jedis.jedis.commands;

import java.util.List;
import java.util.Set;

import be.ciaran.minesync.internal.jedis.args.ExpiryOption;
import be.ciaran.minesync.internal.jedis.params.MigrateParams;
import be.ciaran.minesync.internal.jedis.params.RestoreParams;
import be.ciaran.minesync.internal.jedis.params.ScanParams;
import be.ciaran.minesync.internal.jedis.params.SortingParams;
import be.ciaran.minesync.internal.jedis.resps.ScanResult;
import be.ciaran.minesync.internal.jedis.Response;

public interface KeyPipelineCommands {

  Response<Boolean> exists(String key);

  Response<Long> exists(String... keys);

  Response<Long> persist(String key);

  Response<String> type(String key);

  Response<byte[]> dump(String key);

  Response<String> restore(String key, long ttl, byte[] serializedValue);

  Response<String> restore(String key, long ttl, byte[] serializedValue, RestoreParams params);

  Response<Long> expire(String key, long seconds);

  Response<Long> expire(String key, long seconds, ExpiryOption expiryOption);

  Response<Long> pexpire(String key, long milliseconds);

  Response<Long> pexpire(String key, long milliseconds, ExpiryOption expiryOption);

  Response<Long> expireTime(String key);

  Response<Long> pexpireTime(String key);

  Response<Long> expireAt(String key, long unixTime);

  Response<Long> expireAt(String key, long unixTime, ExpiryOption expiryOption);

  Response<Long> pexpireAt(String key, long millisecondsTimestamp);

  Response<Long> pexpireAt(String key, long millisecondsTimestamp, ExpiryOption expiryOption);

  Response<Long> ttl(String key);

  Response<Long> pttl(String key);

  Response<Long> touch(String key);

  Response<Long> touch(String... keys);

  Response<List<String>> sort(String key);

  Response<Long> sort(String key, String dstkey);

  Response<List<String>> sort(String key, SortingParams sortingParams);

  Response<Long> sort(String key, SortingParams sortingParams, String dstkey);

  Response<List<String>> sortReadonly(String key, SortingParams sortingParams);

  Response<Long> del(String key);

  Response<Long> del(String... keys);

  Response<Long> unlink(String key);

  Response<Long> unlink(String... keys);

  Response<Boolean> copy(String srcKey, String dstKey, boolean replace);

  Response<String> rename(String oldkey, String newkey);

  Response<Long> renamenx(String oldkey, String newkey);

  Response<Long> memoryUsage(String key);

  Response<Long> memoryUsage(String key, int samples);

  Response<Long> objectRefcount(String key);

  Response<String> objectEncoding(String key);

  Response<Long> objectIdletime(String key);

  Response<Long> objectFreq(String key);

  Response<String> migrate(String host, int port, String key, int timeout);

  Response<String> migrate(String host, int port, int timeout, MigrateParams params, String... keys);

  Response<Set<String>> keys(String pattern);

  Response<ScanResult<String>> scan(String cursor);

  Response<ScanResult<String>> scan(String cursor, ScanParams params);

  Response<ScanResult<String>> scan(String cursor, ScanParams params, String type);

  Response<String> randomKey();

}
