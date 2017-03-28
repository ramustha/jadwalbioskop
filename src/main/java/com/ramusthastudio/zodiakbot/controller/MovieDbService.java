package com.ramusthastudio.zodiakbot.controller;

import com.ramusthastudio.zodiakbot.model.DiscoverMovies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDbService {
  @GET("search/movie")
  Call<DiscoverMovies> searchMovies(@Query("api_key") String aApi, @Query("query") String aQuery);
}
