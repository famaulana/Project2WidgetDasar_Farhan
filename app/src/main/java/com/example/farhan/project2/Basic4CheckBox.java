package com.example.farhan.project2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Basic4CheckBox extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    CheckBox c1,c2,c3,c4,c5;
    TextView hasil, jumlah;
    int nHobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic4_check_box);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        c1 = findViewById(R.id.membaca);
        c2 = findViewById(R.id.olahraga);
        c3 = findViewById(R.id.menggambar);
        c4 = findViewById(R.id.menulis);
        c5 = findViewById(R.id.nonton);
        hasil = findViewById(R.id.Hasil);
        jumlah = findViewById(R.id.Jumlah);

        c1.setOnCheckedChangeListener(this);
        c2.setOnCheckedChangeListener(this);
        c3.setOnCheckedChangeListener(this);
        c4.setOnCheckedChangeListener(this);
        c5.setOnCheckedChangeListener(this);

        findViewById(R.id.butonok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

    }

    private void doClick() {
        String thasil = "Hobi Anda : \n";
        int startlen = thasil.length();
        if(c1.isChecked()) thasil+=c1.getText()+"\n";
        if(c2.isChecked()) thasil+=c2.getText()+"\n";
        if(c3.isChecked()) thasil+=c3.getText()+"\n";
        if(c4.isChecked()) thasil+=c4.getText()+"\n";
        if(c5.isChecked()) thasil+=c5.getText()+"\n";

        if(thasil.length()==startlen) thasil+="Pilih salah satu!!";

        hasil.setText(thasil);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if(isChecked) nHobi+=1;
        else nHobi-=1;

        jumlah.setText("Hobi ("+nHobi+"terpilih)");
    }
}
