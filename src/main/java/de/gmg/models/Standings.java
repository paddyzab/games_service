package de.gmg.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Standings extends APIResponse {

    @SerializedName("teams")
    private ArrayList<Standing> teams;

    public void setTeams(ArrayList<Standing> teams) {
        this.teams = teams;
    }

    public ArrayList<Standing> getTeams() {
        return teams;
    }
}
