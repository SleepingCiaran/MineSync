package be.ciaran.minesync.internal.jedis.jedis.commands;

import java.util.List;
import be.ciaran.minesync.internal.jedis.Response;
import be.ciaran.minesync.internal.jedis.args.FlushMode;

public interface SampleBinaryKeyedPipelineCommands {

  Response<Long> waitReplicas(byte[] sampleKey, int replicas, long timeout);

  Response<Object> eval(byte[] script, byte[] sampleKey);

  Response<Object> evalsha(byte[] sha1, byte[] sampleKey);
//
//  Response<Boolean> scriptExists(byte[] sha1, byte[] sampleKey);

  Response<List<Boolean>> scriptExists(byte[] sampleKey, byte[]... sha1s);

  Response<byte[]> scriptLoad(byte[] script, byte[] sampleKey);

  Response<String> scriptFlush(byte[] sampleKey);

  Response<String> scriptFlush(byte[] sampleKey, FlushMode flushMode);

  Response<String> scriptKill(byte[] sampleKey);
}
