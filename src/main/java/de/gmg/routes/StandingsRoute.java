package de.gmg.routes;

import com.google.gson.Gson;
import de.gmg.IFootballApiClient;
import de.gmg.models.Standings;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class StandingsRoute extends MyRoute {

    private static final String STANDINGS_KEY = "standings";
    private final IFootballApiClient iFootballApiClient;
    private final Gson gson;

    public StandingsRoute(IFootballApiClient iFootballApiClient, Gson gson) {
        super(STANDINGS_ROUTE);

        this.iFootballApiClient = iFootballApiClient;
        this.gson = gson;
    }

    @Override
    public Object handle(Request request, Response response) {
        final Standings standings = iFootballApiClient.getStandings(getMapForStandings(request.params(COMP_ID_KEY)));
        response.status(200);

        if (standings.getTeams().size() > 0) {
            return gson.toJson(standings.getTeams());
        } else {
            return "No standings to handle.";
        }
    }


    private static HashMap<String, String> getMapForStandings(String competitionId) {
        final HashMap<String, String> forStandingsMap = new HashMap<String, String>();
        forStandingsMap.put(ACTION_KEY, STANDINGS_KEY);
        forStandingsMap.put(API_KEY, IFootballApiClient.REAL_API_KEY);
        forStandingsMap.put(COMP_ID_KEY, competitionId);

        return forStandingsMap;
    }
}
