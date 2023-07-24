package be.ciaran.minesync.internal.jedis.jedis.params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import be.ciaran.minesync.internal.jedis.Protocol;
import be.ciaran.minesync.internal.jedis.args.Rawable;
import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public abstract class Params {

  private Map<String, Object> params;

  @SuppressWarnings("unchecked")
  public <T> T getParam(String name) {
    if (params == null) return null;

    return (T) params.get(name);
  }

  public byte[][] getByteParams() {
    if (params == null) return new byte[0][];
    ArrayList<byte[]> byteParams = new ArrayList<>();

    for (Entry<String, Object> param : params.entrySet()) {
      byteParams.add(SafeEncoder.encode(param.getKey()));

      Object value = param.getValue();
      if (value != null) {
        if (value instanceof byte[]) {
          byteParams.add((byte[]) value);
        } else if (value instanceof Rawable) {
          byteParams.add(((Rawable) value).getRaw());
        } else if (value instanceof Boolean) {
          byteParams.add(Protocol.toByteArray((boolean) value));
        } else if (value instanceof Integer) {
          byteParams.add(Protocol.toByteArray((int) value));
        } else if (value instanceof Long) {
          byteParams.add(Protocol.toByteArray((long) value));
        } else if (value instanceof Double) {
          byteParams.add(Protocol.toByteArray((double) value));
        } else {
          byteParams.add(SafeEncoder.encode(String.valueOf(value)));
        }
      }
    }

    return byteParams.toArray(new byte[byteParams.size()][]);
  }

  protected boolean contains(String name) {
    if (params == null) return false;

    return params.containsKey(name);
  }

  protected void addParam(String name, Object value) {
    if (params == null) {
      params = new HashMap<>();
    }
    params.put(name, value);
  }

  protected void addParam(String name) {
    if (params == null) {
      params = new HashMap<>();
    }
    params.put(name, null);
  }

  @Override
  public String toString() {
    ArrayList<Object> paramsFlatList = new ArrayList<>();
    if (params != null) {
      for (Entry<String, Object> param : params.entrySet()) {
        paramsFlatList.add(param.getKey());
        Object value = param.getValue();
        if (value != null) {
          paramsFlatList.add(SafeEncoder.encodeObject(value));
        }
      }
    }
    return paramsFlatList.toString();
  }
}
