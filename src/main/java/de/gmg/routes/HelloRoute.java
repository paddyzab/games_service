package de.gmg.routes;

import spark.Request;
import spark.Response;
import spark.Route;

public class HelloRoute extends Route {


    public HelloRoute() {
        super("/hello");
    }

    @Override
    public Object handle(Request request, Response response) {
        return "We will build own own Internet with Blackjack and Bitcoins!";
    }
}
