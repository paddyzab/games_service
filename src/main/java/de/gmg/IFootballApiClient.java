package de.gmg;

import java.util.Map;
import de.gmg.models.Competitions;
import de.gmg.models.Fixture;
import de.gmg.models.Standings;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

public interface IFootballApiClient {

    public static final String REAL_API_KEY = "04340217-e852-a8be-e0e183dcde68";

    @GET("/api/")
    public void getCompetition(@QueryMap Map<String, String> map, Callback<Competitions> competitionCallback);

    @GET("/api/")
    public Competitions getCompetition(@QueryMap Map<String, String> map);

    @GET("/api/")
    public void getFixture(@QueryMap Map<String, String> map, Callback<Fixture> matchCallback);

    @GET("/api/")
    public Fixture getFixture(@QueryMap Map<String, String> map);

    @GET("/api/")
    public void getStandings(@QueryMap Map<String, String> map, Callback<Standings> standingsCallback);

    @GET("/api/")
    public Standings getStandings(@QueryMap Map<String, String> map);
 }