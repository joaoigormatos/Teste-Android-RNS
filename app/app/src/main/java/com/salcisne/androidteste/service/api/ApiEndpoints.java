package com.salcisne.androidteste.service.api;

import com.salcisne.androidteste.model.Produto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoints {
    @GET("produto/find-all")
    Call<List<Produto>> getProdutos();
}