package de.gmg;

import de.gmg.endpoint.Endpoint;
import de.gmg.model.Competitions;
import de.gmg.model.Standing;
import de.gmg.model.Standings;
import java.util.HashMap;
import de.gmg.model.Fixture;
import de.gmg.model.Match;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

public class TheFootballApiClient {

    private final static String apiKey = "04340217-e852-a8be-e0e183dcde68";
    private IFootballApiClient iFootballApiClient;

    @BeforeMethod
    public void setUp() {
        final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Endpoint.API_URL)
                //.setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        iFootballApiClient = restAdapter.create(IFootballApiClient.class);
    }

    @Test
    public void should_return_competition_list() {

        // when
        final Competitions competitions = iFootballApiClient.getCompetition(getMapForCompetition());

        // then
        assertThat("Supported by account competitions", competitions.getCompetitions().size(), equalTo(1));
    }

    @Test
    public void should_return_fixture_list_for_6thMai_day() {

        // given
        final String date = "06.05.2014";
        final String competitionId = "1204";

        // when
        final Fixture fixture = iFootballApiClient.getFixture(getMapForFixtures(competitionId, date));

        // then
        assertThat("Matches for that day", fixture.getMatches().size(), equalTo(1));
    }

    @Test
    public void should_return_winner_of_premiership() {
        // given
        final String competitionId = "1204";

        // when
        final Standings standings = iFootballApiClient.getStandings(getMapForStandings(competitionId));

        // then
        assertEquals(standings.getTeams().get(0).getStandingTeamName(), "Manchester City", "Team on the first place");
    }

    @Test
    public void should_return_fixture_of_games_for_specific_competition_on_specific_date() {
        // given
        final HashMap<String, String> matchParams = getMapForFixtures("1204", "06.05.2014");
        final Callback<Fixture> fixtureCallback = new Callback<Fixture>() {
            @Override
            public void success(Fixture fixture, Response response) {
                final Match match = fixture.getMatches().get(0);
                System.out.println("result of the game was: " + match.getMatchLocalteamScore() + " : " + match.getMatchVisitorteamScore());
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error.getBody());
            }
        };

        // when
        iFootballApiClient.getFixture(matchParams, fixtureCallback);

    }

    @Test
    public void should_return_competition_list_for_specific_account() {
        // given
        final HashMap<String, String> competitionParams = getMapForCompetition();
        final Callback<Competitions> competitionCallback = new Callback<Competitions>() {
            @Override
            public void success(Competitions competitions, Response response) {
                System.out.println("Name of supported competition: " + competitions.getCompetitions().get(0).getName());
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println(error.getBody());
            }
        };

        // when
        iFootballApiClient.getCompetition(competitionParams, competitionCallback);

    }

    @Test
    public void should_return_standings_list_for_specific_competition() {
        // given
        final HashMap<String, String> standingsParams = getMapForStandings("1204");
        final Callback<Standings> standingsCallback = new Callback<Standings>() {
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
        };

        // when
        iFootballApiClient.getStandings(standingsParams, standingsCallback);

    }


    private HashMap<String, String> getMapForFixtures(String competitionId, String matchDate) {
        final HashMap<String, String> forFixturesMap = new HashMap<String, String>();
        forFixturesMap.put("Action", "fixtures");
        forFixturesMap.put("APIKey", apiKey);
        forFixturesMap.put("comp_id", competitionId);
        forFixturesMap.put("match_date", matchDate);

        return forFixturesMap;
    }

    private HashMap<String, String> getMapForCompetition() {
        final HashMap<String, String> forCompetitionMap = new HashMap<String, String>();
        forCompetitionMap.put("Action", "competitions");
        forCompetitionMap.put("APIKey", apiKey);

        return forCompetitionMap;
    }

    private static HashMap<String, String> getMapForStandings(String competitionId) {
        final HashMap<String, String> forStandingsMap = new HashMap<String, String>();
        forStandingsMap.put("Action", "standings");
        forStandingsMap.put("APIKey", apiKey);
        forStandingsMap.put("comp_id", competitionId);

        return forStandingsMap;
    }
}
