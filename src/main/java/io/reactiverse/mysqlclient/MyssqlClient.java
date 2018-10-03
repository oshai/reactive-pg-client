package io.reactiverse.mysqlclient;

import com.github.jasync.sql.db.Connection;
import io.reactiverse.pgclient.PgClient;
import io.reactiverse.pgclient.PgRowSet;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class MyssqlClient implements PgClient {

  private final Connection client;
  private final Vertx vertx;

  public MyssqlClient(Connection client, Vertx vertx) {
    this.client = client;
    this.vertx = vertx;
  }

  @Override
  public PgClient query(String sql, Handler<AsyncResult<PgRowSet>> handler) {
    client.sendQuery(sql).whenCompleteAsync((a, t) -> {
      if (t == null) {
        handler.handle(Future.succeededFuture(new MysqlQueryResult(a).value()));
      } else {
        handler.handle(Future.failedFuture(t));
      }
    },vertx.nettyEventLoopGroup());
    return this;
  }
}
