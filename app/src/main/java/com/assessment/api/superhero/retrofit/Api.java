package com.assessment.api.superhero.retrofit;

import retrofit.RestAdapter;

public class Api {

    public static ApiInterface getClient() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://superheroapi.com/api/10218907272818429")
                .build();

        ApiInterface api = adapter.create(ApiInterface.class);
        return api;
    }

}
