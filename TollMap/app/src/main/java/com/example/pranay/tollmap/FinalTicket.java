package com.example.pranay.tollmap;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FinalTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipts);

        final ImageView imgSplash=(ImageView) findViewById(R.id.success);
        final LinearLayout Layout= (LinearLayout) findViewById(R.id.ticket);
        double total= getIntent().getExtras().getDouble("ttl");
        int noKids= Integer.parseInt(getIntent().getExtras().getString("kid"));
        int noAdults= Integer.parseInt(getIntent().getExtras().getString("ad"));
        TextView amt= (TextView) findViewById(R.id.textView8);
        TextView num= (TextView) findViewById(R.id.textView10);
        amt.setText(String.valueOf(total));
        num.setText(String.valueOf(noAdults)+" Adults "+String.valueOf(noKids)+" Kids");
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                imgSplash.setVisibility(View.INVISIBLE);
//                Layout.setVisibility(View.VISIBLE);
//
//            }
//        }, 2000);
    }
}
