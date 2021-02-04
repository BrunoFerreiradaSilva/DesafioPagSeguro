package com.example.DesagioPagSeguro.all.service;

import com.example.DesagioPagSeguro.all.responses.GitRepoResponse;
import com.example.DesagioPagSeguro.all.responses.PullRequestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicoApi {


    @GET("/search/repositories?q=language:Java&sort=stars&page=page")
    Call<GitRepoResponse> obeterTopicosGitResponse(@Query("page") int chavePage);


    @GET("/repos/{owner}/{repo}/pulls")
    Call<PullRequestResponse> obterListaDePullRequest(@Path("owner")String usuarioDopull, @Path("repo") String nomeDoRepositorio);
}
