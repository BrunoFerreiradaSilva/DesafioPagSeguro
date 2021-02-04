package com.example.DesagioPagSeguro.all.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Items implements Serializable {
    private int id;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("name")
    private String nome;
    @SerializedName("full_name")
    private String NomeCompleto;
    @SerializedName("forks_count")
    private int quantidadeDeForks;
    @SerializedName("stargazers_count")
    private int quantidadeDeEstrlas;
    @SerializedName("owner")
    private ProprietarioDaLista ProprietarioDaListas;
    @SerializedName("description")
    private String descricaoDoRepositorio;
    @SerializedName("pulls_url")
    private String urlDoPull;


    public int getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public int getQuantidadeDeForks() {
        return quantidadeDeForks;
    }

    public int getQuantidadeDeEstrlas() {
        return quantidadeDeEstrlas;
    }

    public ProprietarioDaLista getProprietarioDaListas() {
        return ProprietarioDaListas;
    }

    public String getDescricaoDoRepositorio() {
        return descricaoDoRepositorio;
    }

    public String getUrlDoPull() {
        return urlDoPull;
    }
}
