package be.ciaran.minesync.internal.jedis.jedis.executors;

import be.ciaran.minesync.internal.jedis.CommandObject;
import be.ciaran.minesync.internal.jedis.Connection;
import be.ciaran.minesync.internal.jedis.util.IOUtils;

public class SimpleCommandExecutor implements CommandExecutor {

  protected final Connection connection;

  public SimpleCommandExecutor(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void close() {
    IOUtils.closeQuietly(connection);
  }

  @Override
  public final <T> T executeCommand(CommandObject<T> commandObject) {
    return connection.executeCommand(commandObject);
  }
}
