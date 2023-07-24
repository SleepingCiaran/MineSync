package be.ciaran.minesync.internal.jedis.jedis;

public abstract class Builder<T> {

  public abstract T build(Object data);
}
