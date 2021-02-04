package com.example.DesagioPagSeguro.all.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicoRepositorio {
    private static ServicoApi INSTANCE;
    private ServicoRepositorio(){};
    public static ServicoApi getInstance() {
        if (INSTANCE == null) {
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl("https://api.github.com");
            builder.addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder
                    .build();
            INSTANCE = retrofit.create(ServicoApi.class);
        }
        return INSTANCE;
    }

}
