package de.gmg.routes;

import de.gmg.IFootballApiClient;
import de.gmg.model.Fixture;
import java.util.HashMap;
import spark.Request;
import spark.Response;
import spark.Route;

public class FixtureRoute extends Route {

    final IFootballApiClient iFootballApiClient;

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
        forFixturesMap.put("Action", "fixtures");
        forFixturesMap.put("APIKey", IFootballApiClient.API_KEY);
        forFixturesMap.put("comp_id", competitionId);
        forFixturesMap.put("match_date", matchDate);

        return forFixturesMap;
    }
}
