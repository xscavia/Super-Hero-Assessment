package com.assessment.api.superhero.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Connections {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("group-affiliation")
    @Expose
    private String group_affiliation;
    @SerializedName("relatives")
    @Expose
    private String relatives;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getGroup_affiliation() {
        return group_affiliation;
    }

    public void setGroup_affiliation(String group_affiliation) {
        this.group_affiliation = group_affiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }
}
