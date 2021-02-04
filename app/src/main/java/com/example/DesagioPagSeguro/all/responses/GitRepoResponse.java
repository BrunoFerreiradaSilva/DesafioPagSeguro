package com.example.DesagioPagSeguro.all.responses;

import com.example.DesagioPagSeguro.all.model.Items;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitRepoResponse {

    @SerializedName("total_count")
    private String contagemTotal;
    @SerializedName("incomplete_results")
    private Boolean resultadoIncompleto;
    @SerializedName("items")
    private List<Items> itens;


    public String getContagemTotal() {
        return contagemTotal;
    }

    public Boolean getResultadoIncompleto() {
        return resultadoIncompleto;
    }

    public List<Items> getItens() {
        return itens;
    }

}
