package de.gmg;

import java.util.Map;
import de.gmg.model.Competitions;
import de.gmg.model.Fixture;
import de.gmg.model.Standings;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

public interface IFootballApiClient {

    public static final String ACTION_KEY = "Action";
    public static final String API_KEY = "APIKey";
    public static final String COMP_ID_KEY = "comp_id";
    public static final String MATCH_DATE_KEY = "match_date";
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