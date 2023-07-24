package be.ciaran.minesync.internal.jedis.jedis.args;

import java.util.Locale;
import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public enum GeoUnit implements Rawable {

  M, KM, MI, FT;

  private final byte[] raw;

  private GeoUnit() {
    raw = SafeEncoder.encode(name().toLowerCase(Locale.ENGLISH));
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
