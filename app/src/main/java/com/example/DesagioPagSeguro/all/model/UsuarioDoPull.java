package com.example.DesagioPagSeguro.all.model;

import com.google.gson.annotations.SerializedName;

public class UsuarioDoPull {
    @SerializedName("login")
    private String nomeDoPull;
    @SerializedName("avatar_url")
    private String fotoUsuarioDoPull;

    public String getNomeDoPull() {
        return nomeDoPull;
    }

    public String getFotoUsuarioDoPull() {
        return fotoUsuarioDoPull;
    }
}
