package com.example.farhan.project2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.farhan.project2.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farhan on 19/01/2018.
 */

public class KotaAdapter extends ArrayAdapter<String> {

    String mProvinsi = "";

    public KotaAdapter(Context context, ArrayList<String> listKota) {
        super(context, R.layout.row_spinner_kota, listKota);
    }

    public void setmProvinsi(String provinsi) {
        this.mProvinsi = provinsi;
    }

    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        return getCustomView(position,view, parent);
    }

    @Override
    public View getDropDownView(int position,View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    private View getCustomView(int position, View view, ViewGroup parent) {
        if (view==null)
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.row_spinner_kota, parent, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.textViewTitle);
        tvTitle.setText(getItem(position).substring(0,1));
        TextView tvKota = (TextView) view.findViewById(R.id.textViewKota);
        tvKota.setText(getItem(position));
        TextView tvProvinsi = (TextView) view.findViewById(R.id.textViewProvinsi);
        tvProvinsi.setText(mProvinsi);

        return view;
    }
}
