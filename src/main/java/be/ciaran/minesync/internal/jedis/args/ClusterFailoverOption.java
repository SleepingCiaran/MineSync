package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum ClusterFailoverOption implements Rawable {

  FORCE, TAKEOVER;

  private final byte[] raw;

  private ClusterFailoverOption() {
    this.raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
