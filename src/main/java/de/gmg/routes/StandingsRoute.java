package de.gmg.routes;

import de.gmg.IFootballApiClient;
import de.gmg.model.Standings;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class StandingsRoute extends MyRoute {

    private final IFootballApiClient iFootballApiClient;
    private static final String STANDINGS_KEY = "standings";

    public StandingsRoute(IFootballApiClient iFootballApiClient) {
        super("/standings/:comp_id");

        this.iFootballApiClient = iFootballApiClient;
    }

    @Override
    public Object handle(Request request, Response response) {

        String currentStanding = "";
        response.type(DEFAULT_RESPONSE_TYPE);

        try {
            final Standings standings = iFootballApiClient.getStandings(getMapForStandings(request.params("comp_id")));
            for(int i = 0; i < standings.getTeams().size(); i++) {
                String currentTeamStanding = standings.getTeams().get(i).getStandingTeamName();

                currentStanding += (i + 1) + ". " + currentTeamStanding + System.lineSeparator();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentStanding;
    }


    private static HashMap<String, String> getMapForStandings(String competitionId) {
        final HashMap<String, String> forStandingsMap = new HashMap<String, String>();
        forStandingsMap.put(ACTION_KEY, STANDINGS_KEY);
        forStandingsMap.put(API_KEY, IFootballApiClient.REAL_API_KEY);
        forStandingsMap.put(COMP_ID_KEY, competitionId);

        return forStandingsMap;
    }
}
