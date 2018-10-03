package io.reactiverse.mysqlclient;

import com.github.jasync.sql.db.ResultSet;
import io.reactiverse.pgclient.PgIterator;
import io.reactiverse.pgclient.PgRowSet;

import java.util.List;

public class MysqlRowSet implements PgRowSet {


  private final com.github.jasync.sql.db.ResultSet resultSet;

  public MysqlRowSet(ResultSet resultSet) {
    this.resultSet = resultSet;
  }

  @Override
  public PgIterator iterator() {
    return new MysqlIterator(resultSet.iterator());
  }

  @Override
  public int rowCount() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<String> columnsNames() {
    return resultSet.columnNames();
  }

  @Override
  public int size() {
    return resultSet.size();
  }

  @Override
  public PgRowSet value() {
    return this;
  }

  @Override
  public PgRowSet next() {
    return null;
  }
}
