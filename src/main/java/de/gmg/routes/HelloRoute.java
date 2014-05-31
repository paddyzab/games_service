package de.gmg.routes;

import spark.Request;
import spark.Response;

public class HelloRoute extends MyRoute {


    public HelloRoute() {
        super(HELLO_ROUTE);
    }

    @Override
    public Object handle(Request request, Response response) {
        response.status(200);

        return "We will build own own Internet with Blackjack and Bitcoins!";
    }
}
