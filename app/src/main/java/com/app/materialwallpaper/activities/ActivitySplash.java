package com.app.materialwallpaper.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.app.materialwallpaper.R;

public class ActivitySplash extends AppCompatActivity {

    Boolean isCancelled = false;
    ProgressBar progressBar;
    long nid = 0;
    String url = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);

        if (getIntent().hasExtra("nid")) {
            nid = getIntent().getLongExtra("nid", 0);
            url = getIntent().getStringExtra("external_link");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isCancelled) {
                    if (nid == 0) {
                        if (url.equals("") || url.equals("no_url")) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Intent a = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(a);

                            Intent b = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(b);

                            finish();
                        }
                    } else {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        }, 3000);

    }

}