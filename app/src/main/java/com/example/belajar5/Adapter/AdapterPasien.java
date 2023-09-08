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
import com.example.belajar5.Model.ModelPasien;
import com.example.belajar5.R;

import java.util.ArrayList;

public class AdapterPasien extends RecyclerView.Adapter<AdapterPasien.CardViewHolder>  {
    private final ArrayList<ModelPasien> listPasien;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public AdapterPasien(ArrayList<ModelPasien> listPasien) {
        this.listPasien = listPasien;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pasien, parent, false);
        return  new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {
        ModelPasien pasien = listPasien.get(position);
        Glide.with(holder.itemView.getContext()).load(pasien.getFoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.ivFoto);
        holder.tvName.setText(pasien.getNama());
        holder.tvRs.setText(pasien.getRs());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listPasien.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPasien.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivFoto;
        private final TextView tvName, tvRs;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.pasien_foto);
            tvName = itemView.findViewById(R.id.pasien_nama);
            tvRs = itemView.findViewById(R.id.pasien_rs);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(ModelPasien data);
    }
}
