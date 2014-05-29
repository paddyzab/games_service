package de.gmg.routes;

import de.gmg.IFootballApiClient;
import de.gmg.model.Competitions;
import java.util.HashMap;
import spark.Request;
import spark.Response;
import spark.Route;

public class CompetitionsRoute extends Route {

    final IFootballApiClient iFootballApiClient;

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
        forCompetitionMap.put("Action", "competitions");
        forCompetitionMap.put("APIKey", IFootballApiClient.API_KEY);

        return forCompetitionMap;
    }
}
