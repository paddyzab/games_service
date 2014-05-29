package de.gmg.routes;

import de.gmg.IFootballApiClient;
import de.gmg.model.Competitions;
import java.util.HashMap;
import spark.Request;
import spark.Response;

public class CompetitionsRoute extends MyRoute {

    private final IFootballApiClient iFootballApiClient;
    private static final String COMPETITIONS_KEY = "competitions";

    public CompetitionsRoute(IFootballApiClient iFootballApiClient) {
        super("/competitions");

        this.iFootballApiClient = iFootballApiClient;
    }

    @Override
    public Object handle(Request request, Response response) {
        Competitions competitions =  iFootballApiClient.getCompetition(getMapForCompetition());
        return competitions.getCompetitions().get(0).getName();
    }

    private static HashMap<String, String> getMapForCompetition() {
        final HashMap<String, String> forCompetitionMap = new HashMap<String, String>();
        forCompetitionMap.put(ACTION_KEY, COMPETITIONS_KEY);
        forCompetitionMap.put(API_KEY, IFootballApiClient.REAL_API_KEY);

        return forCompetitionMap;
    }
}
