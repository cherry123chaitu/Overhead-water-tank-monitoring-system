package com.example.project;

import com.google.gson.annotations.SerializedName;

public class WaveLevel {
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @SerializedName("Percent")
    String distance;



    public WaveLevel(String distance) {
        this.distance = distance;
    }
}