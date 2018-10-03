package io.reactiverse.mysqlclient;

import com.github.jasync.sql.db.QueryResult;
import io.reactiverse.pgclient.PgResult;

import java.util.List;

public class MysqlQueryResult implements PgResult<MysqlRowSet> {
  private final QueryResult queryResult;

  public MysqlQueryResult(QueryResult queryResult) {
    this.queryResult = queryResult;
  }

  @Override
  public int rowCount() {
    return (int) queryResult.getRowsAffected();
  }

  @Override
  public List<String> columnsNames() {
    return queryResult.getRows().columnNames();
  }

  @Override
  public int size() {
    return queryResult.getRows().size();
  }

  @Override
  public MysqlRowSet value() {
    return new MysqlRowSet(queryResult.getRows());
  }

  @Override
  public PgResult<MysqlRowSet> next() {
    return null;
  }
}
