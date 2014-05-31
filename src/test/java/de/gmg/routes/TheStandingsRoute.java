package de.gmg.routes;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import de.gmg.IFootballApiClient;
import de.gmg.models.Standing;
import de.gmg.models.Standings;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import spark.Request;
import spark.Response;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;

public class TheStandingsRoute {

    private StandingsRoute tested;
    private IFootballApiClient iFootballApiClientMock;
    private Request requestMock;
    private Response responseMock;
    private final Gson gson = new Gson();

    @BeforeSuite
    public void setUp() {
        iFootballApiClientMock = mock(IFootballApiClient.class);
        requestMock = mock(Request.class);
        responseMock = mock(Response.class);

        tested = new StandingsRoute(iFootballApiClientMock, gson);
    }

    @Test
    public void shouldReturnValidResult() {
        when(iFootballApiClientMock.getStandings(anyMap())).thenReturn(standings());
        Object result = tested.handle(requestMock, responseMock);

        assertNotNull(result, "Competition at this point should not be empty.");
    }

    private Standings standings() {
        Standings standings = new Standings();

        Standing standing1 = new Standing();
        standing1.setStandingId("1");
        standing1.setStandingTeamName("Evil Geniuses");

        Standing standing2 = new Standing();
        standing2.setStandingId("2");
        standing2.setStandingTeamName("Team Liquid");

        standings.setTeams(Lists.newArrayList(standing1, standing2));

        return standings;
    }
}
