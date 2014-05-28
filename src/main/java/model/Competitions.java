package model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Competitions extends APIResponse {

    @SerializedName("Competition")
    ArrayList<Competition> competitions;

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }
}
