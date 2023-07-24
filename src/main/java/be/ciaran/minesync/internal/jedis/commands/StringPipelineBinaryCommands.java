package be.ciaran.minesync.internal.jedis.jedis.commands;

import java.util.List;

import be.ciaran.minesync.internal.jedis.Response;
import be.ciaran.minesync.internal.jedis.args.BitCountOption;
import be.ciaran.minesync.internal.jedis.args.BitOP;
import be.ciaran.minesync.internal.jedis.params.BitPosParams;
import be.ciaran.minesync.internal.jedis.params.GetExParams;
import be.ciaran.minesync.internal.jedis.params.SetParams;
import be.ciaran.minesync.internal.jedis.params.StrAlgoLCSParams;
import be.ciaran.minesync.internal.jedis.params.LCSParams;
import be.ciaran.minesync.internal.jedis.resps.LCSMatchResult;

public interface StringPipelineBinaryCommands {

  Response<String> set(byte[] key, byte[] value);

  Response<String> set(byte[] key, byte[] value, SetParams params);

  Response<byte[]> get(byte[] key);

  /**
   * WARNING: {@link SetParams#get()} MUST NOT be used with this method.
   */
  Response<byte[]> setGet(byte[] key, byte[] value, SetParams params);

  Response<byte[]> getDel(byte[] key);

  Response<byte[]> getEx(byte[] key, GetExParams params);

  Response<Boolean> setbit(byte[] key, long offset, boolean value);

  Response<Boolean> getbit(byte[] key, long offset);

  Response<Long> setrange(byte[] key, long offset, byte[] value);

  Response<byte[]> getrange(byte[] key, long startOffset, long endOffset);

  Response<byte[]> getSet(byte[] key, byte[] value);

  Response<Long> setnx(byte[] key, byte[] value);

  Response<String> setex(byte[] key, long seconds, byte[] value);

  Response<String> psetex(byte[] key, long milliseconds, byte[] value);

  Response<List<byte[]>> mget(byte[]... keys);

  Response<String> mset(byte[]... keysvalues);

  Response<Long> msetnx(byte[]... keysvalues);

  Response<Long> incr(byte[] key);

  Response<Long> incrBy(byte[] key, long increment);

  Response<Double> incrByFloat(byte[] key, double increment);

  Response<Long> decr(byte[] key);

  Response<Long> decrBy(byte[] key, long decrement);

  Response<Long> append(byte[] key, byte[] value);

  Response<byte[]> substr(byte[] key, int start, int end);

  Response<Long> strlen(byte[] key);

  Response<Long> bitcount(byte[] key);

  Response<Long> bitcount(byte[] key, long start, long end);

  Response<Long> bitcount(byte[] key, long start, long end, BitCountOption option);

  Response<Long> bitpos(byte[] key, boolean value);

  Response<Long> bitpos(byte[] key, boolean value, BitPosParams params);

  Response<List<Long>> bitfield(byte[] key, byte[]... arguments);

  Response<List<Long>> bitfieldReadonly(byte[] key, byte[]... arguments);

  Response<Long> bitop(BitOP op, byte[] destKey, byte[]... srcKeys);

  /**
   * @deprecated STRALGO LCS command will be removed from Redis 7.
   * {@link StringPipelineBinaryCommands#lcs(byte[], byte[], LCSParams) LCS} can be used instead of this method.
   */
  @Deprecated
  Response<LCSMatchResult> strAlgoLCSKeys(byte[] keyA, byte[] keyB, StrAlgoLCSParams params);

  Response<LCSMatchResult> lcs(byte[] keyA, byte[] keyB, LCSParams params);
}
