package com.example.anin.cloudcamplayer.Model;

import com.google.gson.annotations.SerializedName;

public class Stream {
    @SerializedName("event_log")
    private EventLog[] eventLog;

    @SerializedName("profile")
    private String profile;

    @SerializedName("gateway_url")
    private String gatewayUrl;

    @SerializedName("mode")
    private String mode;

    @SerializedName("created")
    private String created;

    @SerializedName("client_id")
    private String clientID;

    @SerializedName("id")
    private String id;

    @SerializedName("running")
    private Boolean running;

    @SerializedName("source_id")
    private String sourceID;

    @SerializedName("modified")
    private String modified;

    @SerializedName("user_id")
    private String userID;

    public Stream(){
    }

    public EventLog[] getEventLog() {
        return eventLog;
    }

    public void setEventLog(EventLog[] eventLog) {
        this.eventLog = eventLog;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
