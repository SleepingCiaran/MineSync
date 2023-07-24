package be.ciaran.minesync.internal.jedis.jedis.graph;

import be.ciaran.minesync.internal.jedis.args.Rawable;
import be.ciaran.minesync.internal.jedis.commands.ProtocolCommand;
import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public class GraphProtocol {

  public enum GraphCommand implements ProtocolCommand {

    QUERY,
    RO_QUERY,
    DELETE,
    LIST,
    PROFILE,
    EXPLAIN,
    SLOWLOG,
    CONFIG;

    private final byte[] raw;

    private GraphCommand() {
      raw = SafeEncoder.encode("GRAPH." + name());
    }

    @Override
    public byte[] getRaw() {
      return raw;
    }
  }

  public enum GraphKeyword implements Rawable {

    CYPHER,
    TIMEOUT,
    SET,
    GET,
    __COMPACT("--COMPACT");

    private final byte[] raw;

    private GraphKeyword() {
      raw = SafeEncoder.encode(name());
    }

    private GraphKeyword(String alt) {
      raw = SafeEncoder.encode(alt);
    }

    @Override
    public byte[] getRaw() {
      return raw;
    }
  }
}
