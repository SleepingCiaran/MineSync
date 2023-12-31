package be.ciaran.minesync.internal.jedis.jedis.params;

import static redis.clients.jedis.Protocol.Keyword.AGGREGATE;
import static redis.clients.jedis.Protocol.Keyword.WEIGHTS;

import java.util.ArrayList;
import java.util.List;

import be.ciaran.minesync.internal.jedis.CommandArguments;
import be.ciaran.minesync.internal.jedis.args.Rawable;
import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public class ZParams implements IParams {

  public enum Aggregate implements Rawable {

    SUM, MIN, MAX;

    private final byte[] raw;

    private Aggregate() {
      raw = SafeEncoder.encode(name());
    }

    @Override
    public byte[] getRaw() {
      return raw;
    }
  }

  private final List<Object> params = new ArrayList<>();

  public ZParams weights(final double... weights) {
    params.add(WEIGHTS);
    for (final double weight : weights) {
      params.add(weight);
    }

    return this;
  }

  public ZParams aggregate(final Aggregate aggregate) {
    params.add(AGGREGATE);
    params.add(aggregate);
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {
    params.forEach(param -> args.add(param));
  }
}
