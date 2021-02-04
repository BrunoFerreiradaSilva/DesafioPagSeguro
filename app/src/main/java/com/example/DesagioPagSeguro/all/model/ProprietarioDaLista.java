package com.example.DesagioPagSeguro.all.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProprietarioDaLista implements Serializable {
    @SerializedName("login")
    private String loginProprietario;
    @SerializedName("avatar_url")
    private String imagemFotoRepositorio;

    public String getLoginProprietario() {
        return loginProprietario;
    }

    public String getImagemFotoRepositorio() {
        return imagemFotoRepositorio;
    }
}
