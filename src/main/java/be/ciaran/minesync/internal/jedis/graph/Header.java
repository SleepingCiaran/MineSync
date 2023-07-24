package be.ciaran.minesync.internal.jedis.jedis.graph;

import java.util.List;

/**
 * Query response header interface. Represents the response schema (column names and types)
 */
public interface Header {

  List<ResultSet.ColumnType> getSchemaTypes();

  List<String> getSchemaNames();
}
