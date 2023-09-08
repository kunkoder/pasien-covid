package com.example.belajar5.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.belajar5.Model.ModelPengembang;
import com.example.belajar5.Model.ModelPasien;
import com.example.belajar5.R;

import java.util.ArrayList;

public class AdapterPengembang extends RecyclerView.Adapter<AdapterPengembang.CardViewHolder>  {
    private final ArrayList<ModelPengembang> listPengembang;

    public AdapterPengembang(ArrayList<ModelPengembang> listPengembang) {
        this.listPengembang = listPengembang;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pengembang, parent, false);
        return  new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        ModelPengembang pengembang = listPengembang.get(position);
        Glide.with(holder.itemView.getContext()).load(pengembang.getFoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.ivFoto);
        holder.tvName.setText(pengembang.getNama());
        holder.tvNpm.setText(pengembang.getNpm());
    }

    @Override
    public int getItemCount() {
        return listPengembang.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivFoto;
        private final TextView tvName, tvNpm;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.dev_foto);
            tvName = itemView.findViewById(R.id.dev_nama);
            tvNpm = itemView.findViewById(R.id.dev_npm);
        }
    }
}
