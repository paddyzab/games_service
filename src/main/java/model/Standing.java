package model;

import com.google.gson.annotations.SerializedName;

public class Standing extends APIResponse {

    @SerializedName("stand_id")
    private String standingId;
    @SerializedName("stand_competition_id")
    private String standingCompetitionId;
    @SerializedName("stand_season")
    private String standingSeason;
    @SerializedName("stand_round")
    private String standingRound;
    @SerializedName("stand_stage_id")
    private String standingStageId;
    @SerializedName("stand_group")
    private String standingGroup;
    @SerializedName("stand_country")
    private String standingCountry;
    @SerializedName("stand_team_id")
    private String standingTeamId;
    @SerializedName("stand_team_name")
    private String standingTeamName;
    @SerializedName("stand_status")
    private String standingStatus;
    @SerializedName("stand_recent_form")
    private String standingRecentForm;
    @SerializedName("stand_position")
    private String standingPosition;
    @SerializedName("stand_orverall_gp")
    private String standingOverallGp; //no idea what it is....
    @SerializedName("stand_overall_w")
    private String standingOverallWins;
    @SerializedName("stand_overall_d")
    private String standingsOverallDraws;
    @SerializedName("stand_overall_l")
    private String standingOverallLoses;
    @SerializedName("stand_overall_gs")
    private String standingOverallGoalScores;
    @SerializedName("stand_overall_ga")
    private String standingOverallGoalAgainst;
    @SerializedName("stand_home_gp")
    private String standingHomeGamesPlayed;
    @SerializedName("stand_home_w")
    private String standingHomeWins;
    @SerializedName("stand_home_d")
    private String standingHomeDraws;
    @SerializedName("stand_home_l")
    private String standingHomeLoses;
    @SerializedName("stand_home_gs")
    private String standingHomeGoalsScored;
    @SerializedName("stand_home_ga")
    private String standingHomeGoalsAgainst;
    @SerializedName("stand_away_gp")
    private String standingAwayGamesPlayed;
    @SerializedName("stand_away_w")
    private String standingAwayWins;
    @SerializedName("stand_away_d")
    private String standingAwayDraws;
    @SerializedName("stand_away_l")
    private String standingAwayLoses;
    @SerializedName("stand_away_gs")
    private String standingAwayGoalsScored;
    @SerializedName("stand_away_ga")
    private String standingAwayGoalsAway;
    @SerializedName("stand_gd")
    private String standingGD;
    @SerializedName("stand_points")
    private String standingPoints;
    @SerializedName("stand_desc")
    private String standingDescription;

    public String getStandingId() {
        return standingId;
    }

    public String getStandingCompetitionId() {
        return standingCompetitionId;
    }

    public String getStandingSeason() {
        return standingSeason;
    }

    public String getStandingRound() {
        return standingRound;
    }

    public String getStandingStageId() {
        return standingStageId;
    }

    public String getStandingGroup() {
        return standingGroup;
    }

    public String getStandingCountry() {
        return standingCountry;
    }

    public String getStandingTeamId() {
        return standingTeamId;
    }

    public String getStandingTeamName() {
        return standingTeamName;
    }

    public String getStandingStatus() {
        return standingStatus;
    }

    public String getStandingRecentForm() {
        return standingRecentForm;
    }

    public String getStandingPosition() {
        return standingPosition;
    }

    public String getStandingOverallGp() {
        return standingOverallGp;
    }

    public String getStandingOverallWins() {
        return standingOverallWins;
    }

    public String getStandingsOverallDraws() {
        return standingsOverallDraws;
    }

    public String getStandingOverallLoses() {
        return standingOverallLoses;
    }

    public String getStandingOverallGoalScores() {
        return standingOverallGoalScores;
    }

    public String getStandingOverallGoalAgainst() {
        return standingOverallGoalAgainst;
    }

    public String getStandingHomeGamesPlayed() {
        return standingHomeGamesPlayed;
    }

    public String getStandingHomeWins() {
        return standingHomeWins;
    }

    public String getStandingHomeDraws() {
        return standingHomeDraws;
    }

    public String getStandingHomeLoses() {
        return standingHomeLoses;
    }

    public String getStandingHomeGoalsScored() {
        return standingHomeGoalsScored;
    }

    public String getStandingHomeGoalsAgainst() {
        return standingHomeGoalsAgainst;
    }

    public String getStandingAwayGamesPlayed() {
        return standingAwayGamesPlayed;
    }

    public String getStandingAwayWins() {
        return standingAwayWins;
    }

    public String getStandingAwayDraws() {
        return standingAwayDraws;
    }

    public String getStandingAwayLoses() {
        return standingAwayLoses;
    }

    public String getStandingAwayGoalsScored() {
        return standingAwayGoalsScored;
    }

    public String getStandingAwayGoalsAway() {
        return standingAwayGoalsAway;
    }

    public String getStandingGD() {
        return standingGD;
    }

    public String getStandingPoints() {
        return standingPoints;
    }

    public String getStandingDescription() {
        return standingDescription;
    }
}
