package de.gmg.routes;

import spark.Request;
import spark.Response;

public class HelloRoute extends MyRoute {


    public HelloRoute() {
        super("/hello");
    }

    @Override
    public Object handle(Request request, Response response) {
        return "We will build own own Internet with Blackjack and Bitcoins!";
    }
}
