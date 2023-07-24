package be.ciaran.minesync.internal.jedis.jedis.executors;

import be.ciaran.minesync.internal.jedis.CommandObject;

public interface CommandExecutor extends AutoCloseable {

  <T> T executeCommand(CommandObject<T> commandObject);
}
