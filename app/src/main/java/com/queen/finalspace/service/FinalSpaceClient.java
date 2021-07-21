package com.queen.finalspace.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import static com.queen.finalspace.Constants.FINAL_SPACE_BASE_URL;

public class FinalSpaceClient {

    private static Retrofit retrofit = null;

    public static FinalSpaceApi getRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(FINAL_SPACE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FinalSpaceApi.class);
    }
}
