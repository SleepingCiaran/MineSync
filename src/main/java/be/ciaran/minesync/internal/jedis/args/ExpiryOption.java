package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum ExpiryOption implements Rawable {

  NX, XX, GT, LT;

  private final byte[] raw;

  private ExpiryOption() {
    raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
