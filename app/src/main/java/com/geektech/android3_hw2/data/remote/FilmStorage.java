package com.geektech.android3_hw2.data.remote;

import android.util.Log;

import com.geektech.android3_hw2.data.models.EachFilm;
import com.geektech.android3_hw2.data.models.Films;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {

    public void getFilm(String filmId, FilmCallback callback) {
        RetrofitBuilder.getInstance().getFilm(filmId).enqueue(new Callback<EachFilm>() {
            @Override
            public void onResponse(Call<EachFilm> call, Response<EachFilm> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.success(response.body());
                } else callback.onFailure("Request error");
            }

            @Override
            public void onFailure(Call<EachFilm> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public interface FilmCallback {
        void success(EachFilm film);

        default void onFailure(String errorMsg) {
            Log.e("TAG", "onFailure: " + errorMsg);
        }
    }
}
