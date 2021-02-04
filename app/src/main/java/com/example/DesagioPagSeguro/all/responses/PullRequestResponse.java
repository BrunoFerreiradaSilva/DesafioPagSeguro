package com.example.DesagioPagSeguro.all.responses;

import com.example.DesagioPagSeguro.all.model.Items;
import com.example.DesagioPagSeguro.all.model.PullRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class PullRequestResponse implements Serializable {
        List<Items> itemsList;

    public List<Items> getItemsList() {
        return itemsList;
    }
}
