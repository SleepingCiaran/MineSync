package be.ciaran.minesync.internal.jedis.jedis.params;

import be.ciaran.minesync.internal.jedis.CommandArguments;
import be.ciaran.minesync.internal.jedis.Protocol;
import be.ciaran.minesync.internal.jedis.args.SaveMode;
import be.ciaran.minesync.internal.jedis.util.SafeEncoder;

public class ShutdownParams implements IParams {

  private SaveMode saveMode;
  private boolean now;
  private boolean force;

  public static ShutdownParams shutdownParams() {
    return new ShutdownParams();
  }

  public ShutdownParams saveMode(SaveMode saveMode) {
    this.saveMode = saveMode;
    return this;
  }

  public ShutdownParams nosave() {
    return this.saveMode(SaveMode.NOSAVE);
  }

  public ShutdownParams save() {
    return this.saveMode(SaveMode.SAVE);
  }

  public ShutdownParams now() {
    this.now = true;
    return this;
  }

  public ShutdownParams force() {
    this.force = true;
    return this;
  }

  @Override
  public void addParams(CommandArguments args) {

    if (this.saveMode != null) {
      args.add(SafeEncoder.encode(saveMode.getRaw()));
    }

    if (this.now) {
      args.add(Protocol.Keyword.NOW.getRaw());
    }

    if (this.force) {
      args.add(Protocol.Keyword.FORCE.getRaw());
    }
  }
}
