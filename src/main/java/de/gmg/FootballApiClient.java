package de.gmg;

import de.gmg.endpoint.Endpoint;
import de.gmg.routes.CompetitionsRoute;
import de.gmg.routes.FixtureRoute;
import de.gmg.routes.HelloRoute;
import de.gmg.routes.StandingsRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;
import static spark.Spark.get;

public class FootballApiClient {


    public static final Logger Log = LoggerFactory.getLogger(FootballApiClient.class);

    public static void main(String... args) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Endpoint.API_URL)
                .build();

        final IFootballApiClient iFootballApiClient = restAdapter.create(IFootballApiClient.class);


        // Just example answer.
        get(new HelloRoute());

        // Get available competitions list
        get(new CompetitionsRoute(iFootballApiClient));

        // Get league standings.
        get(new StandingsRoute(iFootballApiClient));

        // Get Fixture for specific day and competition
        get(new FixtureRoute(iFootballApiClient));
    }


}
