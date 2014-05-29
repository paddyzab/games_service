package de.gmg.routes;

import de.gmg.IFootballApiClient;
import de.gmg.model.Fixture;
import java.util.HashMap;
import spark.Request;
import spark.Response;
import spark.Route;

public class FixtureRoute extends Route {

    final IFootballApiClient iFootballApiClient;
    private final static String FIXTURES_KEY = "fixtures";

    public FixtureRoute(IFootballApiClient iFootballApiClient) {
        super("/fixture/:comp_id/:match_date");

        this.iFootballApiClient = iFootballApiClient;
    }

    @Override
    public String handle(Request request, Response response) {

        String fixtureForDay = "";
        response.type("text/plain");

        try {
            Fixture fixture = iFootballApiClient.getFixture(getMapForFixtures(request.params("comp_id"), request.params("match_date")));

            for(int i = 0; i < fixture.getMatches().size(); i++) {
                String formattedTeams = fixture.getMatches().get(i).getMatchLocalteamName() + " vs " + fixture.getMatches().get(0).getMatchVisitorteamName();
                String formattedResult = fixture.getMatches().get(i).getMatchLocalteamScore() + ":" + fixture.getMatches().get(0).getMatchVisitorteamScore();

                fixtureForDay += formattedTeams + " " + formattedResult + System.lineSeparator();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fixtureForDay;
    }

    private static HashMap<String, String> getMapForFixtures(String competitionId, String matchDate) {
        final HashMap<String, String> forFixturesMap = new HashMap<String, String>();
        forFixturesMap.put(IFootballApiClient.ACTION_KEY, FIXTURES_KEY);
        forFixturesMap.put(IFootballApiClient.API_KEY, IFootballApiClient.REAL_API_KEY);
        forFixturesMap.put(IFootballApiClient.COMP_ID_KEY, competitionId);
        forFixturesMap.put(IFootballApiClient.MATCH_DATE_KEY, matchDate);

        return forFixturesMap;
    }
}
