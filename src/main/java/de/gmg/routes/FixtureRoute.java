package de.gmg.routes;

import com.google.gson.Gson;
import de.gmg.IFootballApiClient;
import de.gmg.models.Fixture;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class FixtureRoute extends MyRoute {

    final IFootballApiClient iFootballApiClient;
    private final static String FIXTURES_KEY = "fixtures";
    private final Gson gson;

    public FixtureRoute(IFootballApiClient iFootballApiClient, Gson gson) {
        super(FIXTURE_ROUTE);

        this.iFootballApiClient = iFootballApiClient;
        this.gson = gson;
    }

    @Override
    public String handle(Request request, Response response) {
        final Fixture fixture = iFootballApiClient.getFixture(getMapForFixtures(request.params("comp_id"), request.params("match_date")));
        response.status(200);

        if (fixture.getMatches().size() > 0) {
            return gson.toJson(fixture.getMatches());
        } else {
            return "No games for this day.";
        }
    }

    private static HashMap<String, String> getMapForFixtures(String competitionId, String matchDate) {
        final HashMap<String, String> forFixturesMap = new HashMap<String, String>();
        forFixturesMap.put(ACTION_KEY, FIXTURES_KEY);
        forFixturesMap.put(API_KEY, IFootballApiClient.REAL_API_KEY);
        forFixturesMap.put(COMP_ID_KEY, competitionId);
        forFixturesMap.put(MATCH_DATE_KEY, matchDate);

        return forFixturesMap;
    }
}
