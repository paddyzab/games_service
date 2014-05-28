package model;

import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("ServerAddress")
    String serverAddress;
    @SerializedName("APIKey")
    String apiKey;
    @SerializedName("comp_id")
    String competitionId;
    @SerializedName("match_date")
    String matchDate;

    public String getServerAddress() {
        return serverAddress;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public String getMatchDate() {
        return matchDate;
    }
}
