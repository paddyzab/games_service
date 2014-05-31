package de.gmg.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Match {

    @SerializedName("match_id")
    String matchId;
    @SerializedName("match_static_id")
    String matchStaticId;
    @SerializedName("match_comp_id")
    String matchCompetitionId;
    @SerializedName("match_date")
    String matchDate;
    @SerializedName("match_formatted_date")
    String matchFormattedDate;
    @SerializedName("match_status")
    String matchStatus;
    @SerializedName("match_time")
    String matchTime;
    @SerializedName("match_commentary_available")
    String matchCommentaryAvailable;
    @SerializedName("match_localteam_id")
    String matchLocalteamId;
    @SerializedName("match_localteam_name")
    String matchLocalteamName;
    @SerializedName("match_localteam_score")
    String matchLocalteamScore;
    @SerializedName("match_visitorteam_id")
    String matchVisitorteamId;
    @SerializedName("match_visitorteam_name")
    String matchVisitorteamName;
    @SerializedName("match_visitorteam_score")
    String matchVisitorteamScore;
    @SerializedName("match_ht_score")
    String matchHalftimeScore;
    @SerializedName("match_events")
    List<MatchFact> matchEvents;

    public String getMatchId() {
        return matchId;
    }

    public String getMatchStaticId() {
        return matchStaticId;
    }

    public String getMatchCompetitionId() {
        return matchCompetitionId;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getMatchFormattedDate() {
        return matchFormattedDate;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public String getMatchCommentaryAvailable() {
        return matchCommentaryAvailable;
    }

    public String getMatchLocalteamId() {
        return matchLocalteamId;
    }

    public String getMatchLocalteamName() {
        return matchLocalteamName;
    }

    public String getMatchLocalteamScore() {
        return matchLocalteamScore;
    }

    public String getMatchVisitorteamId() {
        return matchVisitorteamId;
    }

    public String getMatchVisitorteamName() {
        return matchVisitorteamName;
    }

    public String getMatchVisitorteamScore() {
        return matchVisitorteamScore;
    }

    public String getMatchHalftimeScore() {
        return matchHalftimeScore;
    }

    public List<MatchFact> getMatchEvents() {
        return matchEvents;
    }
}
