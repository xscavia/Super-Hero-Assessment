package com.assessment.api.superhero.retrofit;

import com.assessment.api.superhero.pojo.Appearance;
import com.assessment.api.superhero.pojo.Biography;
import com.assessment.api.superhero.pojo.Connections;
import com.assessment.api.superhero.pojo.HeroImage;
import com.assessment.api.superhero.pojo.PowerStats;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ApiInterface {

    @GET("/{id}/image")
    public void fetchCharacterImages(@Path("id") int id,
            Callback<HeroImage> callback);

    @GET("/{id}/powerstats")
    public void fetchPowerstats(@Path("id") int id,
            Callback<PowerStats> callback);

    @GET("/{id}/biography")
    public void fetchBiography(@Path("id") int id,
            Callback<Biography> callback);

    @GET("/{id}/appearance")
    public void fetchAppearance(@Path("id") int id,
            Callback<Appearance> callback);


    @GET("/{id}/connections")
    public void fetchConnections(@Path("id") int id,
            Callback<Connections> callback);

}
