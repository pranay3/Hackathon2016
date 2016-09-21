package com.example.pranay.tollmap;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FinalTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_ticket);

        final ImageView imgSplash=(ImageView) findViewById(R.id.success);
        final LinearLayout Layout= (LinearLayout) findViewById(R.id.ticket);
        int total= getIntent().getExtras().getInt("ttl");
        TextView amt= (TextView) findViewById(R.id.amt);
        amt.setText(String.valueOf(total));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgSplash.setVisibility(View.INVISIBLE);
                Layout.setVisibility(View.VISIBLE);

            }
        }, 2000);
    }
}
