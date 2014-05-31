package de.gmg.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Fixture {

    @SerializedName("matches")
    private ArrayList<Match> matches;

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }
}
