package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum ClusterResetType implements Rawable {

  SOFT, HARD;

  private final byte[] raw;

  private ClusterResetType() {
    this.raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
