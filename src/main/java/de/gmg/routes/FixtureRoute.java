package de.gmg.routes;

import de.gmg.IFootballApiClient;
import de.gmg.model.Fixture;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class FixtureRoute extends MyRoute {

    final IFootballApiClient iFootballApiClient;
    private final static String FIXTURES_KEY = "fixtures";

    public FixtureRoute(IFootballApiClient iFootballApiClient) {
        super("/fixture/:comp_id/:match_date");

        this.iFootballApiClient = iFootballApiClient;
    }

    @Override
    public String handle(Request request, Response response) {

        String fixtureForDay = "";
        response.type(DEFAULT_RESPONSE_TYPE);

        try {
            Fixture fixture = iFootballApiClient.getFixture(getMapForFixtures(request.params("comp_id"), request.params("match_date")));

            if (fixture.getMatches() != null) {
                for (int i = 0; i < fixture.getMatches().size(); i++) {
                    String formattedTeams = fixture.getMatches().get(i).getMatchLocalteamName() + " vs " + fixture.getMatches().get(0).getMatchVisitorteamName();
                    String formattedResult = fixture.getMatches().get(i).getMatchLocalteamScore() + ":" + fixture.getMatches().get(0).getMatchVisitorteamScore();

                    fixtureForDay += formattedTeams + " " + formattedResult + System.lineSeparator();
                }
            } else {
                fixtureForDay = "No games for this day!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fixtureForDay;
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
