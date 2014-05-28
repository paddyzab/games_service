package model;

import com.google.gson.annotations.SerializedName;

public class APIResponse {

    @SerializedName("APIVersion")
    float apiVersion;
    @SerializedName("APIRequestsRemaining")
    int apiRequestsRemaining;
    @SerializedName("DeveloperAuthentication")
    String developerAuthentication;

    @SerializedName("ComputationTime")
    float computationTime;
    @SerializedName("IP")
    String ipAddress;
    @SerializedName("ERROR")
    String errorMessage;
    @SerializedName("ServerName")
    String serverName;
    @SerializedName("ServerAddress")
    String serverAddress;
    @SerializedName("Action")
    String action;
    @SerializedName("Params")
    Params params;

    public float getApiVersion() {
        return apiVersion;
    }

    public int getApiRequestsRemaining() {
        return apiRequestsRemaining;
    }

    public String getDeveloperAuthentication() {
        return developerAuthentication;
    }

    public float getComputationTime() {
        return computationTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getServerName() {
        return serverName;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public String getAction() {
        return action;
    }

    public Params getParams() {
        return params;
    }
}
