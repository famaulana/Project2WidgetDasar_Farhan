package com.example.farhan.project2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Basic3RadioButton extends AppCompatActivity {

//    Basic3RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicwidget3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        r1 = findViewById(R.id.rad1);
//        r2 = findViewById(R.id.rad2);
//        r3 = findViewById(R.id.rad3);
//        r4 = findViewById(R.id.rad4);
        rg = findViewById(R.id.radg);
        hasil = findViewById(R.id.Hasil);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rad1){
                    findViewById(R.id.tjumlahanak).setVisibility(View.GONE);
                }
                else{
                    findViewById(R.id.tjumlahanak).setVisibility(View.VISIBLE);
                }
            }
        });

        findViewById(R.id.Buton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

    }

    private void doClick() {
        String thasil = null;

        //View Group
        if(rg.getCheckedRadioButtonId()!=-1){
            android.widget.RadioButton rb = (android.widget.RadioButton)
                    findViewById(rg.getCheckedRadioButtonId());
            thasil = rb.getText().toString();

            if(rg.getCheckedRadioButtonId()!=R.id.rad1) {
                EditText etJa = findViewById(R.id.jumlahanak);
                thasil += "\nJumlah Anak : " + etJa.getText();
            }
        }

        //Group
//        if(rg.getCheckedRadioButtonId()!=-1){
//            Basic3RadioButton rb = (Basic3RadioButton)
//                    findViewById(rg.getCheckedRadioButtonId());
//            thasil = rb.getText().toString();
//        }

        //Radio Button
//        if(r1.isChecked()){
//            thasil = r1.getText().toString();
//        }else if(r2.isChecked()){
//            thasil = r2.getText().toString();
//        }else if(r3.isChecked()){
//            thasil = r3.getText().toString();
//        }else if(r4.isChecked()){
//            thasil = r4.getText().toString();
//        }

        if (hasil==null){
            hasil.setText("Belum memilih status");
        }else {
            hasil.setText("Status Anda : " + thasil);
        }
    }

}
