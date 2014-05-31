package de.gmg.routes;

import com.google.gson.Gson;
import de.gmg.IFootballApiClient;
import de.gmg.models.Competitions;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class CompetitionsRoute extends MyRoute {

    private static final String COMPETITIONS_KEY = "competitions";
    private final IFootballApiClient iFootballApiClient;
    private final Gson gson;

    public CompetitionsRoute(IFootballApiClient iFootballApiClient, Gson gson) {
        super(COMPETITIONS_ROUTE);

        this.iFootballApiClient = iFootballApiClient;
        this.gson = gson;
    }

    @Override
    public Object handle(Request request, Response response) {
        Competitions competitions =  iFootballApiClient.getCompetition(getMapForCompetition());
        response.status(200);

        if(competitions.getCompetitions().size() > 0) {
            return gson.toJson(competitions.getCompetitions());
        } else {
            return "No competitions to handle.";
        }
    }

    private static HashMap<String, String> getMapForCompetition() {
        final HashMap<String, String> forCompetitionMap = new HashMap<String, String>();
        forCompetitionMap.put(ACTION_KEY, COMPETITIONS_KEY);
        forCompetitionMap.put(API_KEY, IFootballApiClient.REAL_API_KEY);

        return forCompetitionMap;
    }
}
