package com.example.farhan.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.farhan.project2.adapter.KotaAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Basic5Spinner extends AppCompatActivity {

    Spinner profinsi, kota;
    TextView hasil;
    String[] [] arKota = {{"Jakarta Barat","Jakarta Selatan","Jakarta Timur","Jakarta Utara"},
            {"Bandung", "Bekasi", "Cirebon"},{"Magelang", "Semarang", "Surakarta"},
            {"Banyuwangi","Malang" , "Surabaya"},{"Denpasar","Nusa Dua"}};
    ArrayList<String> listKota = new ArrayList<>();
    KotaAdapter adapter;

    //49

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic5_spinner);

        profinsi = findViewById(R.id.Spinner);
        kota = findViewById(R.id.Spinner2);
        hasil = findViewById(R.id.View);

        findViewById(R.id.Butonok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

        adapter = new KotaAdapter(this,listKota);
        kota.setAdapter(adapter);

        profinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota[pos]));
                adapter.setmProvinsi((String)profinsi.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                kota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void doClick() {
        StringBuilder builder = new StringBuilder();
        builder.append("Wilayah Provinsi ");
        builder.append(profinsi.getSelectedItem().toString());
        builder.append(" Kota ");
        builder.append(kota.getSelectedItem().toString());
        builder.append("\n\n\n");

        builder.append("Kota yang tidak dipilih adalah : \n\n");

        String [] arProvinsi = getResources().getStringArray(R.array.provinsi);
        int posProv = profinsi.getSelectedItemPosition();
        int posKota = kota.getSelectedItemPosition();

        for (int i = 0; i < arProvinsi.length; i++){
            builder.append(arProvinsi[i]).append(":\n");
            for (int j = 0; j < arKota[i].length; j++){
                if (!(i==posProv && j==posKota)){
                    builder.append("\t").append(arKota[i][j]).append("\n");
                }
            }
            builder.append("\n");
        }

        hasil.setText(builder);
    }
}
