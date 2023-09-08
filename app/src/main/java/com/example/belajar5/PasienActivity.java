package com.example.belajar5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajar5.Adapter.AdapterPasien;
import com.example.belajar5.Model.ModelPasien;

import java.util.ArrayList;
import java.util.Collection;

public class PasienActivity extends AppCompatActivity {
    private RecyclerView recviewPasien;
    private final ArrayList<ModelPasien> listPasien = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasien);

        Toolbar toolbarPasien = findViewById(R.id.toolbar_pasien);
        setSupportActionBar(toolbarPasien);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Pasien");

        recviewPasien = findViewById(R.id.recview_pasien);
        recviewPasien.setHasFixedSize(true);

        listPasien.addAll(getListPasien());
        showList();
    }

    private void showList() {
        recviewPasien.setLayoutManager(new LinearLayoutManager(this));
        AdapterPasien adapterPasien = new AdapterPasien(listPasien);
        recviewPasien.setAdapter(adapterPasien);

        adapterPasien.setOnItemClickCallback(data -> {
            Toast.makeText(this, "Detail " + data.getNama(), Toast.LENGTH_SHORT).show();
            Intent intentDetailPasien = new Intent(this, DetailPasienActivity.class);
            intentDetailPasien.putExtra("FOTO", data.getFoto());
            intentDetailPasien.putExtra("NAMA", data.getNama());
            intentDetailPasien.putExtra("JK", data.getJk());
            intentDetailPasien.putExtra("USIA", data.getUsia());
            intentDetailPasien.putExtra("RS", data.getRs());
            startActivity(intentDetailPasien);
        });
    }

    private ArrayList<ModelPasien> getListPasien() {
        TypedArray dataFoto = getResources().obtainTypedArray(R.array.data_foto);
        String[] dataNama = getResources().getStringArray(R.array.data_nama);
        String[] dataJk = getResources().getStringArray(R.array.data_jk);
        String[] dataUsia = getResources().getStringArray(R.array.data_usia);
        String[] dataRs = getResources().getStringArray(R.array.data_rs);

        ArrayList<ModelPasien> listPasien = new ArrayList<>();
        for(int i=0; i<dataNama.length; i++) {
            ModelPasien pasien = new ModelPasien();
            pasien.setFoto(dataFoto.getResourceId(i, 0));
            pasien.setNama(dataNama[i]);
            pasien.setJk(dataJk[i]);
            pasien.setUsia(dataUsia[i]);
            pasien.setRs(dataRs[i]);
            listPasien.add(pasien);
        }
        dataFoto.recycle();
        return listPasien;
    }
}
