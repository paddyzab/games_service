package de.gmg;

import com.google.gson.Gson;
import de.gmg.endpoint.Endpoint;
import de.gmg.routes.CompetitionsRoute;
import de.gmg.routes.FixtureRoute;
import de.gmg.routes.HelloRoute;
import de.gmg.routes.StandingsRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;
import static spark.Spark.get;
import static spark.Spark.setPort;

public class FootballApiClient {

    public static final Logger Log = LoggerFactory.getLogger(FootballApiClient.class);

    public static void main(String... args) {

        final Gson gson = new Gson();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Endpoint.API_URL)
                .build();

        final IFootballApiClient iFootballApiClient = restAdapter.create(IFootballApiClient.class);

        setPort(9090);

        // Just example answer.
        get(new HelloRoute(iFootballApiClient));

        // Get available competitions list
        get(new CompetitionsRoute(iFootballApiClient, gson));

        // Get league standings.
        get(new StandingsRoute(iFootballApiClient, gson));

        // Get Fixture for specific day and competition
        get(new FixtureRoute(iFootballApiClient, gson));
    }


}
