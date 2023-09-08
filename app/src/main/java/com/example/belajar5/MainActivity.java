package com.example.belajar5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toPasien(View view) {
        Intent intentPasien = new Intent(this, PasienActivity.class);
        startActivity(intentPasien);
    }

    public void toPengembang(View view) {
        Intent intentPengembang = new Intent(this, PengembangActivity.class);
        startActivity(intentPengembang);
    }
}
