package com.isoneday.basic2desember;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isoneday.basic2desember.activity.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //untuk melakukan delay atau penundaan ke activity berikutnya
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah 3 detik delay maka pindah ke halaman utama
                startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                //untuk menghilangkan / kill activity dalam memory/stack
                finish();
            }
        },3000);
    }
}
