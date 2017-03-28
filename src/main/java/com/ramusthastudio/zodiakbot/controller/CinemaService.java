package com.ramusthastudio.zodiakbot.controller;

import com.ramusthastudio.zodiakbot.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CinemaService {

  @GET("jadwal-bioskop")
  Call<Result> cinemaToday(@Query("k") String aKey, @Query("id") String aCityId);
}
