package de.gmg.routes;

import de.gmg.IFootballApiClient;
import spark.Request;
import spark.Response;

public class TodayFixtureRoute extends  MyRoute {

    protected TodayFixtureRoute(IFootballApiClient iFootballApiClient, String path) {
        super(path, iFootballApiClient);
    }

    @Override
    public Object handle(Request request, Response response) {
        return null;
    }
}
