package com.assessment.api.superhero.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PowerStats {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("intelligence")
    @Expose
    private String intelligence;
    @SerializedName("strength")
    @Expose
    private String strength;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("durability")
    @Expose
    private String durability;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("combat")
    @Expose
    private String combat;

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

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }
}
