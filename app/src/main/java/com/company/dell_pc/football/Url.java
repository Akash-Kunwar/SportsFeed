
package com.company.dell_pc.football;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;

public class Url {

    @SerializedName("match")
    @Expose
    private String match;

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

}
