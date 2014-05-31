package de.gmg.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Fixture  extends APIResponse {

    @SerializedName("matches")
    ArrayList<Match> matches;

    public ArrayList<Match> getMatches() {
        return matches;
    }
}
