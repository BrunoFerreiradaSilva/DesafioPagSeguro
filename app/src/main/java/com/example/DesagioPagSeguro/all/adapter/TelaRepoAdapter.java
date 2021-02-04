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
import com.example.DesagioPagSeguro.all.model.Items;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TelaRepoAdapter  extends RecyclerView.Adapter<TelaRepoAdapter.TelaRepoViewHolder> {
    Context context;
    List<Items> itemsList;
    RecyclerView recyclerepo;
    private static RepoClickListener itemClickListener;

    public TelaRepoAdapter(Context context, List<Items> itemsList, RepoClickListener itemClickListener) {
        this.context = context;
        this.itemsList = itemsList;
        TelaRepoAdapter.itemClickListener = itemClickListener;
    }



    @NonNull
    @Override
    public TelaRepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_repo, parent, false);
        return new TelaRepoViewHolder(viewCriada);
    }


    @Override
    public void onBindViewHolder(@NonNull TelaRepoViewHolder holder, int position) {
        Items items = itemsList.get(position);
        TextView quantidadeDeForks = holder.itemView.findViewById(R.id.forks_projeto);
        TextView userName = holder.itemView.findViewById(R.id.user_name_repo);
        TextView nomeDoRepositorio = holder.itemView.findViewById(R.id.nome_repositorio);
        TextView descricaoRepositorio = holder.itemView.findViewById(R.id.descricao_repositorio);
        TextView quantidadeDeStars = holder.itemView.findViewById(R.id.stars_projeto);
        ImageView imagemDoAvatar = holder.itemView.findViewById(R.id.imagem_avatar_repo);
        TextView nomeComRepositorio = holder.itemView.findViewById(R.id.nome_sobrenome_repo);


        quantidadeDeForks.setText(String.valueOf(items.getQuantidadeDeForks()));
        userName.setText(items.getProprietarioDaListas().getLoginProprietario());
        nomeDoRepositorio.setText(items.getNome());
        descricaoRepositorio.setText(items.getDescricaoDoRepositorio());
        quantidadeDeStars.setText(String.valueOf(items.getQuantidadeDeEstrlas()));
        Picasso.get().load(items.getProprietarioDaListas().getImagemFotoRepositorio()).into(imagemDoAvatar);
        nomeComRepositorio.setText(items.getNomeCompleto());

        holder.itemView.setOnClickListener(v -> {
            if(itemClickListener != null){
                itemClickListener.onItemClicado(items);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public static class TelaRepoViewHolder extends RecyclerView.ViewHolder {
        public TelaRepoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface RepoClickListener{
        void onItemClicado(Items items);
    }
}
