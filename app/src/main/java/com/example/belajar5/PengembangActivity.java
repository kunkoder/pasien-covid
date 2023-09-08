package com.example.belajar5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import com.example.belajar5.Adapter.AdapterPasien;
import com.example.belajar5.Adapter.AdapterPengembang;
import com.example.belajar5.Model.ModelPasien;
import com.example.belajar5.Model.ModelPengembang;

import java.util.ArrayList;

public class PengembangActivity extends AppCompatActivity {
    private RecyclerView recviewPengembang;
    private final ArrayList<ModelPengembang> listPengembang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengembang);

        Toolbar toolbarPengembang = findViewById(R.id.toolbar_pengembang);
        setSupportActionBar(toolbarPengembang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Daftar Pengembang");

        recviewPengembang = findViewById(R.id.recview_pengembang);
        recviewPengembang.setHasFixedSize(true);

        listPengembang.addAll(getListPengembang());
        showList();
    }

    private void showList() {
        recviewPengembang.setLayoutManager(new LinearLayoutManager(this));
        AdapterPengembang adapterPengembang = new AdapterPengembang(listPengembang);
        recviewPengembang.setAdapter(adapterPengembang);
    }

    private ArrayList<ModelPengembang> getListPengembang() {
        TypedArray dataFoto = getResources().obtainTypedArray(R.array.dev_foto);
        String[] dataNama = getResources().getStringArray(R.array.dev_nama);
        String[] dataNpm = getResources().getStringArray(R.array.dev_npm);

        ArrayList<ModelPengembang> listPengembang = new ArrayList<>();
        for(int i=0; i<dataNama.length; i++) {
            ModelPengembang pengembang = new ModelPengembang();
            pengembang.setFoto(dataFoto.getResourceId(i, 0));
            pengembang.setNama(dataNama[i]);
            pengembang.setNpm(dataNpm[i]);
            listPengembang.add(pengembang);
        }
        dataFoto.recycle();
        return listPengembang;
    }
}
