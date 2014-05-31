package de.gmg.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Competitions extends APIResponse {

    @SerializedName("Competition")
    private ArrayList<Competition> competitions;

    public void setCompetitions(ArrayList<Competition> competitions) {
        this.competitions = competitions;
    }

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }
}
