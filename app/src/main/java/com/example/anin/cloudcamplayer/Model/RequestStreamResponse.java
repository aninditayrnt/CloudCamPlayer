package com.example.anin.cloudcamplayer.Model;

import com.google.gson.annotations.SerializedName;

public class RequestStreamResponse {
    @SerializedName("stream")
    private Stream stream;

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }
}


