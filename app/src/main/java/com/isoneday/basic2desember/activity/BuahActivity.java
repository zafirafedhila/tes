package com.isoneday.basic2desember.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.isoneday.basic2desember.R;
import com.isoneday.basic2desember.adapter.BuahAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuahActivity extends AppCompatActivity {
    // setdata buah
    String namabuah[] = {"alpukat", "apel", "ceri", "durian", "manggis"};
    int gambarbuah[] = {R.drawable.alpukat
            , R.drawable.apel
            , R.drawable.ceri
            , R.drawable.durian
            , R.drawable.manggis};
    int linkbuah[] = {R.string.linkAlpukat
            , R.string.linkApel
            , R.string.linkCeri
            , R.string.linkDurian
            , R.string.linkManggis};
    int detailbuah[] = {R.string.alpukat,
            R.string.apel,
            R.string.ceri,
            R.string.durian,
            R.string.manggis};
    //view
    @BindView(R.id.listbuah)
    ListView listbuah;
    @BindView(R.id.gridbuah)
    GridView gridbuah;
    private int data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah);
        ButterKnife.bind(this);
        Intent getdata = getIntent();
        data = getdata.getIntExtra("kode", 0);
        if (data == 1) {
            //untuk menghubungkan data dengan view (listview/bebas) - > adapter
            BuahAdapter adapter = new BuahAdapter(this, namabuah, gambarbuah,1);
            //hubungkan adapter ke view
            listbuah.setAdapter(adapter);
            //aksi ketika list di klik
            listbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(BuahActivity.this, DetailBuahActivity.class);
                    i.putExtra("nB", namabuah[position]);
                    i.putExtra("gB", gambarbuah[position]);
                    i.putExtra("dB", detailbuah[position]);
                    i.putExtra("lB", linkbuah[position]);
                    startActivity(i);
                }
            });
        } else {
            listbuah.setVisibility(View.GONE);
            gridbuah.setVisibility(View.VISIBLE);
            //untuk menghubungkan data dengan view (listview/bebas) - > adapter
            BuahAdapter adapter = new BuahAdapter(this, namabuah, gambarbuah,2);
            //hubungkan adapter ke view
            gridbuah.setAdapter(adapter);
            gridbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(BuahActivity.this, DetailBuahActivity.class);
                    i.putExtra("nB", namabuah[position]);
                    i.putExtra("gB", gambarbuah[position]);
                    i.putExtra("dB", detailbuah[position]);
                    i.putExtra("lB", linkbuah[position]);
                    startActivity(i);
                }
            });
        }

    }
}
