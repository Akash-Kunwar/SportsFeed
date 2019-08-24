
package com.company.dell_pc.football;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import com.google.gson.annotations.Expose;

public class BatTeam {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("innings")
    @Expose
    private List<Inning> innings = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Inning> getInnings() {
        return innings;
    }

    public void setInnings(List<Inning> innings) {
        this.innings = innings;
    }

}
