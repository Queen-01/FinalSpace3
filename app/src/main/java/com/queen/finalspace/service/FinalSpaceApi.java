package com.queen.finalspace.service;

import com.queen.finalspace.model.Episode;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FinalSpaceApi {
    @GET("/api/v0/episode")
    Call<List<Episode>> getEpisode();
}
