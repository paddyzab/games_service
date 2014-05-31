package de.gmg.routes;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import de.gmg.IFootballApiClient;
import de.gmg.models.Competition;
import de.gmg.models.Competitions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import spark.Request;
import spark.Response;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;

public class TheCompetitionsRoute {

    private CompetitionsRoute tested;
    private IFootballApiClient iFootballApiClientMock;
    private Request requestMock;
    private Response responseMock;
    private final Gson gson = new Gson();

    @BeforeSuite
    public void setUp() {
        iFootballApiClientMock = mock(IFootballApiClient.class);
        requestMock = mock(Request.class);
        responseMock = mock(Response.class);

        tested = new CompetitionsRoute(iFootballApiClientMock, gson);
    }

    @Test
    public void shouldReturnValidResult() {
        when(iFootballApiClientMock.getCompetition(anyMap())).thenReturn(competitions());
        Object result = tested.handle(requestMock, responseMock);

        assertNotNull(result, "Competition at this point should not be empty.");
    }

    private Competitions competitions() {
        Competitions competitions = new Competitions();

        Competition competition1 = new Competition();
        competition1.setId("1");
        competition1.setName("Code S");
        competition1.setRegion("Whole World");

        Competition competition2 = new Competition();
        competition2.setId("2");
        competition2.setName("Noobs vs Pros");
        competition2.setName("Alpha Centauri");

        competitions.setCompetitions(Lists.newArrayList(competition1, competition2));

        return competitions;
    }

}
