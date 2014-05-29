package de.gmg.model;

import com.google.gson.annotations.SerializedName;

public class Competition extends APIResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("region")
    private String region;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getRegion() {
        return region;
    }
}
