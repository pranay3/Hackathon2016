package com.example.pranay.tollmap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MonDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView timings= (TextView) findViewById(R.id.timing);
        TextView title= (TextView) findViewById(R.id.title);
        TextView price= (TextView) findViewById(R.id.price);
        TextView adult= (TextView) findViewById(R.id.adult);
        TextView kid= (TextView) findViewById(R.id.kid);
        int monTag= getIntent().getExtras().getInt("Name");
        if(monTag==11)
        {
            title.setText("Bangalore Palace");
            timings.setText("Timings: 8am to 8 pm");
            price.setText("Prices:");
            adult.setText("Adults: Rs. 120");
            kid.setText("kids: Rs. 60");
        }
        else if(monTag==12)
        {
            title.setText("Vishveswaraiya Museum ");
            timings.setText("Timings: 8am to 5 pm");
            price.setText("Prices:");
            adult.setText("Adults: Rs. 100");
            kid.setText("kids: Rs. 50");
        }

        else if(monTag==13)
        {
            title.setText("Vidhan Soudha ");
            timings.setText("Timings: 7am to 4 pm");
            price.setText("Prices:");
            adult.setText("Adults: Rs. 80");
            kid.setText("kids: Rs. 40");
        }
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
}
