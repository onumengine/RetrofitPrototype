package com.example.retrofitprototype;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService
{
    @GET("")
    Call<String> getLyrics(@Query("artist")String artist, @Query("song")String song);
}
