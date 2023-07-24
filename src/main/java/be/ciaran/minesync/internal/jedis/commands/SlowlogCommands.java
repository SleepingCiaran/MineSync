package be.ciaran.minesync.internal.jedis.jedis.commands;

import java.util.List;
import be.ciaran.minesync.internal.jedis.resps.Slowlog;

public interface SlowlogCommands {

  String slowlogReset();

  long slowlogLen();

  List<Slowlog> slowlogGet();

  List<Object> slowlogGetBinary();

  List<Slowlog> slowlogGet(long entries);

  List<Object> slowlogGetBinary(long entries);

}
