package be.ciaran.minesync.internal.jedis.jedis.providers;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import be.ciaran.minesync.internal.jedis.CommandArguments;
import be.ciaran.minesync.internal.jedis.Connection;
import be.ciaran.minesync.internal.jedis.ConnectionFactory;
import be.ciaran.minesync.internal.jedis.ConnectionPool;
import be.ciaran.minesync.internal.jedis.HostAndPort;
import be.ciaran.minesync.internal.jedis.JedisClientConfig;
import be.ciaran.minesync.internal.jedis.util.Pool;

public class PooledConnectionProvider implements ConnectionProvider {

  private final Pool<Connection> pool;

  public PooledConnectionProvider(HostAndPort hostAndPort) {
    this(new ConnectionFactory(hostAndPort));
  }

  public PooledConnectionProvider(HostAndPort hostAndPort, JedisClientConfig clientConfig) {
    this(new ConnectionFactory(hostAndPort, clientConfig));
  }

  public PooledConnectionProvider(PooledObjectFactory<Connection> factory) {
    this(factory, new GenericObjectPoolConfig<>());
  }

  public PooledConnectionProvider(PooledObjectFactory<Connection> factory, GenericObjectPoolConfig<Connection> poolConfig) {
    this(new ConnectionPool(factory, poolConfig));
  }

  private PooledConnectionProvider(Pool<Connection> pool) {
    this.pool = pool;
  }

  @Override
  public void close() {
    pool.close();
  }

  public final Pool<Connection> getPool() {
    return pool;
  }

  @Override
  public Connection getConnection() {
    return pool.getResource();
  }

  @Override
  public Connection getConnection(CommandArguments args) {
    return pool.getResource();
  }
}
