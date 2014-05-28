import endpoint.Endpoint;
import java.util.HashMap;
import model.Competitions;
import model.Fixture;
import model.Match;
import model.Standing;
import model.Standings;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FootballApiClient {


    public final static String apiKey = "04340217-e852-a8be-e0e183dcde68";

    public static void main(String... args) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Endpoint.API_URL)
                //.setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        IFootballApiClient iFootballApiClient = restAdapter.create(IFootballApiClient.class);

        //TODO: competitions should be enums not a strings
        HashMap<String, String> matchParams = getMapForFixtures("1204", "06.05.2014");
        iFootballApiClient.getMatch(matchParams, new Callback<Fixture>() {

            @Override
            public void success(Fixture fixture, Response response) {
                Match match = fixture.getMatches().get(0);
                System.out.println("result of the game was: " + match.getMatchLocalteamScore() + " : " + match.getMatchVisitorteamScore());
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error.getBody());
            }
        });

        HashMap<String, String> competitionParams = getMapForCompetition();
        iFootballApiClient.getCompetition(competitionParams, new Callback<Competitions>() {
            @Override
            public void success(Competitions competitions, Response response) {
                System.out.println("Name of supported competition: " + competitions.getCompetitions().get(0).getName());
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error.getBody());
            }
        });

        HashMap<String, String> standingsParams = getMapForStandings("1204");
        iFootballApiClient.getStandings(standingsParams, new Callback<Standings>() {
            @Override
            public void success(Standings standings, Response response) {

                for(Standing standing : standings.getTeams()) {
                    System.out.println("Standing team: " + standing.getStandingTeamName());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error.getBody());
            }
        });
    }

    private static HashMap<String, String> getMapForFixtures(String competitionId, String matchDate) {
        HashMap<String, String> forFixturesMap = new HashMap<String, String>();
        forFixturesMap.put("Action", "fixtures");
        forFixturesMap.put("APIKey", apiKey);
        forFixturesMap.put("comp_id", competitionId);
        forFixturesMap.put("match_date", matchDate);

        return forFixturesMap;
    }

    private static HashMap<String, String> getMapForCompetition() {
        HashMap<String, String> forCompetitionMap = new HashMap<String, String>();
        forCompetitionMap.put("Action", "competitions");
        forCompetitionMap.put("APIKey", apiKey);

        return forCompetitionMap;
    }

    private static HashMap<String, String> getMapForStandings(String competitionId) {
        HashMap<String, String> forStandingsMap = new HashMap<String, String>();
        forStandingsMap.put("Action", "standings");
        forStandingsMap.put("APIKey", apiKey);
        forStandingsMap.put("comp_id", competitionId);

        return forStandingsMap;
    }

}
