package com.rifki192102139.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button _mahasiswaBtn;
    private Intent _mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        _mahasiswaBtn = (Button) findViewById(R.id.mahasiswaBtn);

        _mahasiswaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _mahasiswa = new Intent(getApplicationContext(),MasterMahasiswa.class);
                startActivity(_mahasiswa);
            }
        });
    }
}