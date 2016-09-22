package com.example.pranay.tollmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MonDetail extends AppCompatActivity
{
    NumberPicker np1,np2;
    private int monTag;
    int val=0;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monument_enter_details);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
//
//        TextView timings= (TextView) findViewById(R.id.timing);
//        TextView title= (TextView) findViewById(R.id.title);
//        TextView price= (TextView) findViewById(R.id.textView10);
//        TextView adult= (TextView) findViewById(R.id.adult);
//        TextView kid= (TextView) findViewById(R.id.kid);
        Button payBt= (Button) findViewById(R.id.bt_pay);
//        tv = (TextView) findViewById(R.id.amount);
//        monTag= getIntent().getExtras().getInt("Name");
//        if(monTag==11)
//        {
//            title.setText("Taj Mahal");
//            timings.setText("Timings: 8am to 8 pm");
//            price.setText("Tickets");
//            adult.setText("Adults: Rs. 120");
//            kid.setText("kids: Rs. 60");
//        }
//        else if(monTag==12)
//        {
//            title.setText("Vishveswaraiya Museum ");
//            timings.setText("Timings: 8am to 5 pm");
//            price.setText("Tickets");
//            adult.setText("Adults: Rs. 100");
//            kid.setText("kids: Rs. 50");
//        }
//
//        else if(monTag==13)
//        {
//            title.setText("Vidhan Soudha ");
//            timings.setText("Timings: 7am to 4 pm");
//            price.setText("Tickets");
//            adult.setText("Adults: Rs. 80");
//            kid.setText("kids: Rs. 40");
//        }

//        np1 = (NumberPicker) findViewById(R.id.numberPicker1);
//        np2 = (NumberPicker) findViewById(R.id.numberPicker2);
//        String[] nums = new String[10];
//        for(int i=0; i<nums.length; i++)
//            nums[i] = Integer.toString(i);
//        np1.setMinValue(0);
//        np1.setMaxValue(10);
//        np1.setWrapSelectorWheel(false);
//        np1.setDisplayedValues(nums);
//        np1.setValue(0);
//        np1.setOnValueChangedListener(MonDetail.this);
//
//        np2.setMinValue(0);
//        np2.setMaxValue(10);
//        np2.setWrapSelectorWheel(false);
//        np2.setDisplayedValues(nums);
//        np2.setValue(0);
//        np2.setOnValueChangedListener(MonDetail.this);
        final EditText adult=(EditText) findViewById(R.id.numberPicker1);
        final EditText kid=(EditText) findViewById(R.id.numberPicker2);

        payBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noAdult= adult.getText().toString();
                String noKid= kid.getText().toString();
                val= (20*Integer.parseInt(noAdult))+(10*Integer.parseInt(noKid));

                int errCode = 0 ;
                Intent pmt = new Intent(MonDetail.this, PaymentPage.class);
                pmt.putExtra("payMoney", val*1.0);
                pmt.putExtra("merchantName","Taj Mahal, Agra");
                pmt.putExtra("purchaseType","monument") ;
                pmt.putExtra("noAdult",noAdult) ;
                pmt.putExtra("noKid",noKid) ;
                MonDetail.this.startActivity(pmt);

                Log.i("MonDetail(): ","payment activity completed") ;

                    /*Intent myIntent = new Intent(MonDetail.this, FinalTicket.class);
                    myIntent.putExtra("ttl", val); //Optional parameter
                myIntent.putExtra("ad", noAdult);
                myIntent.putExtra("kid", noKid);
                   MonDetail.this.startActivity(myIntent);*/

            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

//    @Override
//    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//            if(picker==np1){
//                noAdults=newVal;
//            }
//            if (picker==np2){
//                noKids=newVal;
//            }
//        val= (20*noAdults)+(10*noKids);
//        if(monTag==11){
//            val= (120*noAdults)+(60*noKids);
//            tv.setText(String.valueOf(val));
//        }
//        else if(monTag==12){
//          `  val= (100*noAdults)+(50*noKids);
//            tv.setText(String.valueOf(val));
//        }
//        else if(monTag==13){
//            val= (80*noAdults)+(40*noKids);
//            tv.setText(String.valueOf(val));
//        }
//    }
}
