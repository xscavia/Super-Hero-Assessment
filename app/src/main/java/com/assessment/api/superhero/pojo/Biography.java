package com.assessment.api.superhero.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Biography {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("biography")
    @Expose
    private String biography;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full-name")
    @Expose
    private String full_name;
    @SerializedName("alter-egos")
    @Expose
    private String alter_egos;
    @SerializedName("place-of-birth")
    @Expose
    private String place_of_birth;
    @SerializedName("first-appearance")
    @Expose
    private String first_appearance;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("alignment")
    @Expose
    private String alignment;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAlter_egos() {
        return alter_egos;
    }

    public void setAlter_egos(String alter_egos) {
        this.alter_egos = alter_egos;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public String getFirst_appearance() {
        return first_appearance;
    }

    public void setFirst_appearance(String first_appearance) {
        this.first_appearance = first_appearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }


}
