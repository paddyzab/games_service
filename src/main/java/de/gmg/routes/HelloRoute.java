package de.gmg.routes;

import de.gmg.IFootballApiClient;
import spark.Request;
import spark.Response;

public class HelloRoute extends MyRoute {


    public HelloRoute(IFootballApiClient iFootballApiClient) {
        super(HELLO_ROUTE, iFootballApiClient);
    }

    @Override
    public Object handle(Request request, Response response) {
        response.status(200);

        return "We will build own own Internet with Blackjack and Bitcoins!";
    }
}
