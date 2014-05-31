package de.gmg.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Standings extends APIResponse {

    @SerializedName("teams")
    ArrayList<Standing> teams;

    public ArrayList<Standing> getTeams() {
        return teams;
    }
}
