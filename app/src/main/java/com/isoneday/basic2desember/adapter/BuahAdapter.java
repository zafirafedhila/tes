package com.isoneday.basic2desember.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isoneday.basic2desember.R;
import com.isoneday.basic2desember.activity.BuahActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuahAdapter extends BaseAdapter {
    String namabuah[];
    int gambuah[];
    Activity act;
    int angka;

    //construktor -> untuk mengirim nilai
    public BuahAdapter(BuahActivity buahActivity, String[] namabuah, int[] gambarbuah, int i) {
        this.namabuah = namabuah;
        gambuah = gambarbuah;
        act = buahActivity;
        angka=i;
    }

    @Override
    public int getCount() {
        return gambuah.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //untuk tampilan yang akan kita sisipkan ke layout listview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //layanan membuat sebuah tampilan dalam bentuk popup -> inflater
        LayoutInflater inflater = act.getLayoutInflater();
 if (angka==1){
     convertView = inflater.inflate(R.layout.tampilanbuah, null);

 }else{
     convertView = inflater.inflate(R.layout.tampilangridbuah, null);

 }
//        convertView = inflater.inflate(R.layout.tampilanbuah, null);
        ViewHolder holder = new ViewHolder(convertView);
        //setdata
        holder.txtnamabuah.setText(namabuah[position]);
        holder.imgbuah.setImageResource(gambuah[position]);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imgbuah)
        ImageView imgbuah;
        @BindView(R.id.txtnamabuah)
        TextView txtnamabuah;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
