package model;

import com.google.gson.annotations.SerializedName;

public class MatchFact {

    @SerializedName("event_id")
    private String eventId;
    @SerializedName("evet_match_id")
    private String evetMatchId;
    @SerializedName("event_type")
    private String eventType;
    @SerializedName("event_minute")
    private String eventMinute;
    @SerializedName("event_team")
    private String eventTeam;
    @SerializedName("event_player")
    private String eventPlayer;
    @SerializedName("event_player_id")
    private String eventPlayerId;
    @SerializedName("event_result")
    private String eventResult;

    public String getEventId() {
        return eventId;
    }

    public String getEvetMatchId() {
        return evetMatchId;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventMinute() {
        return eventMinute;
    }

    public String getEventTeam() {
        return eventTeam;
    }

    public String getEventPlayer() {
        return eventPlayer;
    }

    public String getEventPlayerId() {
        return eventPlayerId;
    }

    public String getEventResult() {
        return eventResult;
    }
}
