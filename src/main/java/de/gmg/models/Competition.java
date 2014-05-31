package de.gmg.models;

import com.google.gson.annotations.SerializedName;

public class Competition {

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

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRegion(String region) {
        this.region = region;
    }
}
