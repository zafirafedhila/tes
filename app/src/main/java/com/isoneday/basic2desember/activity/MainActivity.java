package com.isoneday.basic2desember.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.isoneday.basic2desember.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onListview(View view) {
        //pindah halaman
        Intent i = new Intent(this, BuahActivity.class);
        i.putExtra("kode", 1);
        startActivity(i);
    }

    public void onGridview(View view) {
        Intent i = new Intent(this, BuahActivity.class);
        i.putExtra("kode", 2);
        startActivity(i);
    }
}
