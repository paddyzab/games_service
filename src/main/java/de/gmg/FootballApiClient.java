package de.gmg;

import de.gmg.endpoint.Endpoint;
import de.gmg.model.Competitions;
import de.gmg.model.Fixture;
import de.gmg.model.Standings;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;

public class FootballApiClient {


    public final static String apiKey = "04340217-e852-a8be-e0e183dcde68";
    public static final Logger Log = LoggerFactory.getLogger(FootballApiClient.class);

    public static void main(String... args) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Endpoint.API_URL)
                .build();

        final IFootballApiClient iFootballApiClient = restAdapter.create(IFootballApiClient.class);


        // Just example answer.
        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "We will build own own Internet with Blackjack and Bitcoins!";
            }
        });

        // Get available competitions list
        get(new Route("/competitions") {
            @Override
            public Object handle(Request request, Response response) {
                Competitions competitions =  iFootballApiClient.getCompetition(getMapForCompetition());
                return competitions.getCompetitions().get(0).getName();
            }
        });

        // Get league standings.
        get(new Route("/standings/:comp_id") {
            @Override
            public Object handle(Request request, Response response) {

                String currentStanding = "";
                response.type("text/plain");

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
        });

        get(new Route("/fixture/:comp_id/:match_date") {
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
        });
    }

    private static HashMap<String, String> getMapForStandings(String competitionId) {
        final HashMap<String, String> forStandingsMap = new HashMap<String, String>();
        forStandingsMap.put("Action", "standings");
        forStandingsMap.put("APIKey", apiKey);
        forStandingsMap.put("comp_id", competitionId);

        return forStandingsMap;
    }

    private static HashMap<String, String> getMapForCompetition() {
        final HashMap<String, String> forCompetitionMap = new HashMap<String, String>();
        forCompetitionMap.put("Action", "competitions");
        forCompetitionMap.put("APIKey", apiKey);

        return forCompetitionMap;
    }

    private static HashMap<String, String> getMapForFixtures(String competitionId, String matchDate) {
        final HashMap<String, String> forFixturesMap = new HashMap<String, String>();
        forFixturesMap.put("Action", "fixtures");
        forFixturesMap.put("APIKey", apiKey);
        forFixturesMap.put("comp_id", competitionId);
        forFixturesMap.put("match_date", matchDate);

        return forFixturesMap;
    }
}
