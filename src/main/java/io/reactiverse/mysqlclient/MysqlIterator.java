package io.reactiverse.mysqlclient;

import com.github.jasync.sql.db.RowData;
import io.reactiverse.pgclient.PgIterator;
import io.reactiverse.pgclient.Row;

import java.util.Iterator;

public class MysqlIterator implements PgIterator {
  private final Iterator<RowData> iterator;

  public MysqlIterator(Iterator<RowData> iterator) {
    this.iterator = iterator;
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public Row next() {
    return new MysqlRow(iterator.next());
  }
}
