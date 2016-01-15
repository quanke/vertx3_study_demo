package name.quanke.study.vertx.first;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyFirstVerticle extends AbstractVerticle {

  @Override
  public void start(Future<Void> fut) {
    vertx
        .createHttpServer()
        .requestHandler(r -> {
          r.response().end("Hello from my first " +
              "Vert.x 3 application port is " +config().getInteger("http.port",8080));
        })
        .listen(config().getInteger("http.port",8080),
                result -> {
          if (result.succeeded()) {
            fut.complete();
          } else {
            fut.fail(result.cause());
          }
        });
  }
}