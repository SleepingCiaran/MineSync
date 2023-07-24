package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum ClientPauseMode implements Rawable {

  ALL, WRITE;

  private final byte[] raw;

  private ClientPauseMode() {
    raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
