
package com.company.dell_pc.football;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inning {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("wkts")
    @Expose
    private String wkts;
    @SerializedName("overs")
    @Expose
    private String overs;
    @SerializedName("decl")
    @Expose
    private String decl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getWkts() {
        return wkts;
    }

    public void setWkts(String wkts) {
        this.wkts = wkts;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public String getDecl() {
        return decl;
    }

    public void setDecl(String decl) {
        this.decl = decl;
    }

}
