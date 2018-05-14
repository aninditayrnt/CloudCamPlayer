package com.example.anin.cloudcamplayer.Model;

import com.google.gson.annotations.SerializedName;

public class EventLog {
    @SerializedName("name")
    private String name;

    @SerializedName("ts")
    private String ts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
