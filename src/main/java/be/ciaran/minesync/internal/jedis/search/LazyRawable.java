package be.ciaran.minesync.internal.jedis.jedis.search;

import be.ciaran.minesync.internal.jedis.args.Rawable;

class LazyRawable implements Rawable {

  private byte[] raw = null;

  public void setRaw(byte[] raw) {
    this.raw = raw;
  }

  @Override
  public byte[] getRaw() {
    return raw;
  }
}
