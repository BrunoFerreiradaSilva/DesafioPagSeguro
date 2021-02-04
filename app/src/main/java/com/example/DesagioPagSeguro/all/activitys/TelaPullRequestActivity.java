package com.example.DesagioPagSeguro.all.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.DesagioPagSeguro.R;
import com.example.DesagioPagSeguro.all.adapter.TelaPullRequestAdapter;
import com.example.DesagioPagSeguro.all.model.Items;
import com.example.DesagioPagSeguro.all.model.PullRequest;
import com.example.DesagioPagSeguro.all.responses.PullRequestResponse;
import com.example.DesagioPagSeguro.all.service.ServicoRepositorio;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaPullRequestActivity extends AppCompatActivity {
    public static final String EXTRA = "extra";
    public Items items;
    RecyclerView recyclerPullRequest;
    String PROP_LISTA;
    String NOME_REPO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pull_request);
        items = (Items) getIntent().getSerializableExtra(EXTRA);
        recyclerPullRequest = findViewById(R.id.recycle_pull_lista);

        obterListaDePullRequest();
    }

    private void obterListaDePullRequest() {
        PROP_LISTA = items.getProprietarioDaListas().getLoginProprietario();
        NOME_REPO = items.getNome();

        ServicoRepositorio.getInstance()
                .obterListaDePullRequest(PROP_LISTA,NOME_REPO)
                .enqueue(new Callback<PullRequestResponse>() {
                    @Override
                    public void onResponse(Call<PullRequestResponse> call, Response<PullRequestResponse> response) {
                        PullRequestResponse pullRequestResponse = response.body();
//                        PullRequest requestResponseList = pullRequestResponse.getRequestResponses();
//                        configuraAdapterPullRequest(requestResponseList);



                    }

                    @Override
                    public void onFailure(Call<PullRequestResponse> call, Throwable t) {
                        Toast.makeText(TelaPullRequestActivity.this, "erro", Toast.LENGTH_SHORT).show();;
                    }
                });
    }

    private void configuraAdapterPullRequest(List<PullRequestResponse> pullRequestResponse) {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(TelaPullRequestActivity.this);
        recyclerPullRequest.setLayoutManager(linearLayoutManager);
        recyclerPullRequest.setAdapter(new TelaPullRequestAdapter(this, pullRequestResponse));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}