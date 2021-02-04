package com.example.DesagioPagSeguro.all.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.DesagioPagSeguro.R;
import com.example.DesagioPagSeguro.all.model.Items;
import com.example.DesagioPagSeguro.all.responses.GitRepoResponse;
import com.example.DesagioPagSeguro.all.adapter.TelaRepoAdapter;
import com.example.DesagioPagSeguro.all.service.ServicoRepositorio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaRepoActivity extends AppCompatActivity implements TelaRepoAdapter.RepoClickListener {
    private final String TITULO_APPBAR = "Github JavaPop";
    private final int PAGINA_ATUAL = 1;
    RecyclerView recyclerRepo;
    RecyclerView.LayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_repo);
        setTitle(TITULO_APPBAR);
        recyclerRepo = findViewById(R.id.recycle_repo_principal);
        obtemRepositorios();

    }

    private void obtemRepositorios() {
        ServicoRepositorio.getInstance()
                .obeterTopicosGitResponse(PAGINA_ATUAL)
                .enqueue(new Callback<GitRepoResponse>() {
                    @Override
                    public void onResponse(Call<GitRepoResponse> call, Response<GitRepoResponse> response) {
                        GitRepoResponse gitResponse = response.body();
                        List<Items> listaRepoGit = gitResponse.getItens();
                        configuraAdapterRepoGit(listaRepoGit);

                    }

                    @Override
                    public void onFailure(Call<GitRepoResponse> call, Throwable t) {
//                        mostraErro();
                    }
                });
    }


    private void configuraAdapterRepoGit(List<Items> itemsList) {
        linearLayoutManager = new LinearLayoutManager(TelaRepoActivity.this);
        recyclerRepo.setLayoutManager(linearLayoutManager);
        recyclerRepo.setAdapter(new TelaRepoAdapter(this, itemsList, this));
    }

    public void onItemClicado(Items items){
        Intent intent = new Intent(this, TelaPullRequestActivity.class);
        intent.putExtra(TelaPullRequestActivity.EXTRA, items);
        startActivity(intent);
    }
}