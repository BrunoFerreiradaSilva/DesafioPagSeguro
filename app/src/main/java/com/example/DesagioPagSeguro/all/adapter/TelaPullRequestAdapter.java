package com.example.DesagioPagSeguro.all.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.DesagioPagSeguro.R;
import com.example.DesagioPagSeguro.all.responses.PullRequestResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TelaPullRequestAdapter extends RecyclerView.Adapter<TelaPullRequestAdapter.TelaPullRequestViewHolder> {
    Context context;
    List<PullRequestResponse> requestResponses;

    public TelaPullRequestAdapter(Context context, List<PullRequestResponse> requestResponses) {
        this.context = context;
        this.requestResponses = requestResponses;
    }

    @NonNull
    @Override
    public TelaPullRequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pull_request, parent, false);
        return new TelaPullRequestViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull TelaPullRequestViewHolder holder, int position) {
        PullRequestResponse pullRequestResponse = requestResponses.get(position);
        TextView userName = holder.itemView.findViewById(R.id.nome_usuario_pull_request);
        TextView nomeDoRepositorio = holder.itemView.findViewById(R.id.nome_completo_usuario_pull_request);
        TextView descricaoRepositorio = holder.itemView.findViewById(R.id.descricao_pull_request);
        ImageView imagemDoAvatar = holder.itemView.findViewById(R.id.imagem_usuario_pull_request);

//
//        userName.setText(pullRequestResponse.getUsuarioDoPull().getNomeDoPull());
//        nomeDoRepositorio.setText(pullRequestResponse.getTituloDoPull());
//        descricaoRepositorio.setText(pullRequestResponse.getDescricaoDoPull());
//        Picasso.get().load(pullRequestResponse.getUsuarioDoPull().getFotoUsuarioDoPull()).into(imagemDoAvatar);


    }

    @Override
    public int getItemCount() {
        return requestResponses.size();
    }

    public class TelaPullRequestViewHolder extends RecyclerView.ViewHolder {
        public TelaPullRequestViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
