package be.ciaran.minesync.internal.jedis.jedis.search.schemafields;

import be.ciaran.minesync.internal.jedis.params.IParams;
import be.ciaran.minesync.internal.jedis.search.FieldName;

public abstract class SchemaField implements IParams {

  protected final FieldName fieldName;

  public SchemaField(String fieldName) {
    this.fieldName = new FieldName(fieldName);
  }

  public SchemaField(FieldName fieldName) {
    this.fieldName = fieldName;
  }

  public SchemaField as(String attribute) {
    fieldName.as(attribute);
    return this;
  }
}
