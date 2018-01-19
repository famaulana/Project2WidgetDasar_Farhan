package com.example.farhan.project2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Basic2Input extends AppCompatActivity {

    EditText nama, tahun;
    Button buton;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nama = findViewById(R.id.etnama);
        tahun = findViewById(R.id.ettahun);
        buton = findViewById(R.id.etbuton);
        hasil = findViewById(R.id.ethasil);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String Nama = nama.getText().toString();
            int Tahun = Integer.parseInt(tahun.getText().toString());
            int Usia = 2018 - Tahun;
            hasil.setText("Nama : " + Nama + "\nUsia : " + Usia);
        }
        else {

        }
    }

    private boolean isValid() {
        boolean valid = true;

        String Nama = nama.getText().toString();
        String Tahun = tahun.getText().toString();

        if(Nama.isEmpty()) {
            nama.setError("Nama belum di isi");
            valid = false;
        }else if(Tahun.isEmpty()){
            tahun.setError("Tahun belum di isi");
            valid = false;
        }else {
            nama.setError(null);
        }

        if(Nama.length()<3){
            nama.setError("Nama terlalu pendek");
            valid = false;
        }else if(Tahun.length()!=4) {
            tahun.setError("Tahun bukan berformat yyyy");
            valid = false;
        }else {
            tahun.setError(null);
        }


        return valid;
    }

}
