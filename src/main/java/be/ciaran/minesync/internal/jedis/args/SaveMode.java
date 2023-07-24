package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum SaveMode implements Rawable {

  /**
   * Prevent a DB saving operation even if one or more save points are configured.
   */
  NOSAVE,

  /**
   * Force a DB saving operation even if no save points are configured.
   */
  SAVE;

  private final byte[] raw;

  private SaveMode() {
    raw = SafeEncoder.encode(name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
