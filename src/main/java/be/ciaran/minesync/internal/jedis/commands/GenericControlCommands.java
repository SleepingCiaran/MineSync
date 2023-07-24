package be.ciaran.minesync.internal.jedis.jedis.commands;

import java.util.List;
import be.ciaran.minesync.internal.jedis.Module;
import be.ciaran.minesync.internal.jedis.params.FailoverParams;

public interface GenericControlCommands extends ConfigCommands, ScriptingControlCommands, SlowlogCommands {

  String failover();

  String failover(FailoverParams failoverParams);

  String failoverAbort();

  List<Module> moduleList();
}
