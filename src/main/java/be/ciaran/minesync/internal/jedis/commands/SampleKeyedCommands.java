package be.ciaran.minesync.internal.jedis.jedis.commands;

import java.util.List;
import be.ciaran.minesync.internal.jedis.args.FlushMode;

public interface SampleKeyedCommands {

  long waitReplicas(String sampleKey, int replicas, long timeout);

  Object eval(String script, String sampleKey);

  Object evalsha(String sha1, String sampleKey);

  Boolean scriptExists(String sha1, String sampleKey);

  List<Boolean> scriptExists(String sampleKey, String... sha1s);

  String scriptLoad(String script, String sampleKey);

  String scriptFlush(String sampleKey);

  String scriptFlush(String sampleKey, FlushMode flushMode);

  String scriptKill(String sampleKey);
}
