package de.gmg;

import de.gmg.endpoint.Endpoint;
import java.util.HashMap;
import de.gmg.model.Competitions;
import de.gmg.model.Standing;
import de.gmg.model.Standings;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FootballApiClient {


    public final static String apiKey = "04340217-e852-a8be-e0e183dcde68";

    public static void main(String... args) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Endpoint.API_URL)
                .build();

        IFootballApiClient iFootballApiClient = restAdapter.create(IFootballApiClient.class);


    }

}
