package be.ciaran.minesync.internal.jedis.jedis.args;

import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

/**
 * Enum object describing flushing mode.
 */
public enum FlushMode implements Rawable {

  /**
   * flushes synchronously
   */
  SYNC,

  /**
   * flushes asynchronously
   */
  ASYNC;

  private final byte[] raw;

  private FlushMode() {
    raw = SafeEncoder.encode(this.name());
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
