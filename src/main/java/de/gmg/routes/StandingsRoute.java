package de.gmg.routes;

import de.gmg.IFootballApiClient;
import de.gmg.models.Standings;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class StandingsRoute extends MyRoute {

    private final IFootballApiClient iFootballApiClient;
    private static final String STANDINGS_KEY = "standings";

    public StandingsRoute(IFootballApiClient iFootballApiClient) {
        super(STANDINGS_ROUTE);

        this.iFootballApiClient = iFootballApiClient;
    }

    @Override
    public Object handle(Request request, Response response) {

        String currentStanding = "";
        response.type(DEFAULT_RESPONSE_TYPE);

        try {
            final Standings standings = iFootballApiClient.getStandings(getMapForStandings(request.params("comp_id")));

            if (standings.getTeams().size() > 0) {
            for(int i = 0; i < standings.getTeams().size(); i++) {
                response.status(200);

                String currentTeamStanding = standings.getTeams().get(i).getStandingTeamName();
                currentStanding += (i + 1) + ". " + currentTeamStanding + System.lineSeparator();
            }
            } else {
                response.status(404);

                currentStanding = "Current standings are empty.";
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
