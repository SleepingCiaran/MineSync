package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum SortingOrder implements Rawable {

  ASC, DESC;

  private final byte[] raw;

  private SortingOrder() {
    raw = SafeEncoder.encode(this.name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
