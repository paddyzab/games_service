package de.gmg.routes;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import de.gmg.IFootballApiClient;
import de.gmg.models.Fixture;
import de.gmg.models.Match;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import spark.Request;
import spark.Response;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;

public class TheFixtureRoute {

    private FixtureRoute tested;
    private IFootballApiClient iFootballApiClientMock;
    private Request requestMock;
    private Response responseMock;
    private final Gson gson = new Gson();

    @BeforeSuite
    public void setUp() {
        iFootballApiClientMock = mock(IFootballApiClient.class);
        requestMock = mock(Request.class);
        responseMock = mock(Response.class);

        tested = new FixtureRoute(iFootballApiClientMock, gson);
    }

    @Test
    public void shouldReturnValidResult() {
        when(iFootballApiClientMock.getFixture(anyMap())).thenReturn(fixture());
        Object result = tested.handle(requestMock, responseMock);

        assertNotNull(result, "Competition at this point should not be empty.");
    }


    public Fixture fixture() {
        Fixture fixture = new Fixture();

        Match match1 = new Match();
        match1.setMatchId("1");
        match1.setMatchDate("01.01.1111");

        Match match2 = new Match();
        match2.setMatchId("2");
        match1.setMatchDate("02.02.2222");

        fixture.setMatches(Lists.newArrayList(match1, match2));

        return fixture;
    }

}
