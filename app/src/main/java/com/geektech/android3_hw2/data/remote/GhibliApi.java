package com.geektech.android3_hw2.data.remote;

import com.geektech.android3_hw2.data.models.EachFilm;
import com.geektech.android3_hw2.data.models.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET("films/{id}")
    Call<EachFilm> getFilm(@Path("id") String id);

    @GET("films")
    Call<List<Films>> getFilms();
}
