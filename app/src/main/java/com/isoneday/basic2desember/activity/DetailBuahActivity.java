package com.isoneday.basic2desember.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.isoneday.basic2desember.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBuahActivity extends AppCompatActivity {

    @BindView(R.id.imgbuah)
    ImageView imgbuah;
    @BindView(R.id.txtdetailbuah)
    TextView txtdetailbuah;
    private Intent tangkapdata;
    private int datawiki;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//tangkap data
        tangkapdata = getIntent();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datawiki = tangkapdata.getIntExtra("lB",0);
            Intent kirimdata = new Intent(DetailBuahActivity.this,WikiBuahActivity.class);
            kirimdata.putExtra("lB",datawiki);
            startActivity(kirimdata);
            }
        });
        setview();
    }

    private void setview() {
        txtdetailbuah.setText(tangkapdata.getIntExtra("dB",0));
        imgbuah.setImageResource(tangkapdata.getIntExtra("gB",0));

        ActionBar bar = getSupportActionBar();
        bar.setTitle(tangkapdata.getStringExtra("nB"));
    }
}
