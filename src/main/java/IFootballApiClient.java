import java.util.Map;
import model.Competitions;
import model.Fixture;
import model.Match;
import model.Standing;
import model.Standings;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.QueryMap;

public interface IFootballApiClient {

    @GET("/api/")
    public void getCompetition(@QueryMap Map<String, String> map, Callback<Competitions> competitionCallback);

    @GET("/api/")
    public void getMatch(@QueryMap Map<String, String> map, Callback<Fixture> matchCallback);

    @GET("/api/")
    public void getStandings(@QueryMap Map<String, String> map, Callback<Standings> standingsCallback);
 }