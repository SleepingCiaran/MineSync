package be.ciaran.minesync.internal.jedis.jedis.providers;

import be.ciaran.minesync.internal.jedis.CommandArguments;
import be.ciaran.minesync.internal.jedis.Connection;

public class ManagedConnectionProvider implements ConnectionProvider {

  private Connection connection;

  public final void setConnection(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void close() {
  }

  @Override
  public final Connection getConnection() {
    return connection;
  }

  @Override
  public final Connection getConnection(CommandArguments args) {
    return connection;
  }
}
