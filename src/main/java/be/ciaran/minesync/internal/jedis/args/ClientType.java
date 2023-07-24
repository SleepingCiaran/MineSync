package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum ClientType implements Rawable {

  NORMAL, MASTER, SLAVE, REPLICA, PUBSUB;

  private final byte[] raw;

  private ClientType() {
    raw = SafeEncoder.encode(name().toLowerCase());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
