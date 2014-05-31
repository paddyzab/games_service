package de.gmg.routes;

import spark.Route;

public abstract class MyRoute extends Route {

    public static final String HELLO_ROUTE = "/hello";
    public static final String COMPETITIONS_ROUTE = "/competitions";
    public static final String STANDINGS_ROUTE = "/standings/:comp_id";
    public static final String FIXTURE_ROUTE = "/fixture/:comp_id/:match_date";

    public static final String ACTION_KEY = "Action";
    public static final String API_KEY = "APIKey";
    public static final String COMP_ID_KEY = "comp_id";
    public static final String MATCH_DATE_KEY = "match_date";

    public static final String DEFAULT_RESPONSE_TYPE = "text/plain";

    protected MyRoute(String path) {
        super(path);
    }
}