package com.example.myfirstapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PenggunaService {
    @GET("getPenggunaByUsernamePassword")
    Call<List<Pengguna>> signin(@Path("username") String username, @Path("password") String password);
}
