package com.example.belajar5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPasienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pasien);

        Toolbar toolbarPasien = findViewById(R.id.toolbar_pasien);
        setSupportActionBar(toolbarPasien);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Pasien");

        ImageView ivFoto = findViewById(R.id.pasien_foto);
        TextView tvNama = findViewById(R.id.pasien_nama);
        TextView tvJk = findViewById(R.id.pasien_jk);
        TextView tvUsia = findViewById(R.id.pasien_usia);
        TextView tvRs = findViewById(R.id.pasien_rs);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            int foto = bundle.getInt("FOTO");
            String nama = bundle.getString("NAMA");
            String jk = bundle.getString("JK");
            String usia = bundle.getString("USIA");
            String rs = bundle.getString("RS");

            ivFoto.setImageResource(foto);
            tvNama.setText(nama);
            tvJk.setText(jk);
            tvUsia.setText(usia);
            tvRs.setText(rs);
        }
    }
}
