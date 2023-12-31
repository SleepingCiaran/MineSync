package be.ciaran.minesync.internal.jedis.jedis.graph;

public interface Statistics {

  int nodesCreated();

  int nodesDeleted();

  int indicesCreated();

  int indicesDeleted();

  int labelsAdded();

  int relationshipsDeleted();

  int relationshipsCreated();

  int propertiesSet();

  boolean cachedExecution();

  String queryIntervalExecutionTime();
}
