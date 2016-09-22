package com.example.pranay.tollmap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by pupatel on 9/21/2016.
 */
public class PaymentPage extends AppCompatActivity{
    static Map<String,String> merchantMap = new HashMap<>() ;
    private static String SERVICE_ENDPOINT = "https://companion-server.herokuapp.com/vdp/";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Button backButton ;
    private double moneyPaid =100.00 ;
    private String merchantName ="TajMahal, Agra";
    private String merchantId ="12345678" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        //merchantId = getIntent().getExtras().getString("merchantId") ;
        moneyPaid = getIntent().getExtras().getDouble("payMoney") ;
        merchantName = getIntent().getExtras().getString("merchantName") ;

        VISAPAYLOAD.payMoney = moneyPaid+"" ;
       // Log.d("merchant(): ",merchantId) ;

        final TextView moneyText = (TextView) findViewById(R.id.moneyText) ;
        final TextView merchantText = (TextView) findViewById(R.id.merchantText) ;
        final ImageView success  = (ImageView) findViewById(R.id.success);
        final ImageView failure  = (ImageView) findViewById(R.id.failure);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MyTask task = new MyTask() ;
                try {
                    task.execute() ;
                    String result = task.get(5, TimeUnit.SECONDS) ;
                    Log.d("final Result: ",result) ;
                    if("success".equalsIgnoreCase(result)){
                        moneyText.setText("Payment Successful of");
                        merchantText.setText("Rs "+moneyPaid+" at "+merchantName) ;

                        success.setVisibility(View.VISIBLE);
                        //moneyText.setTextColor(Color.rgb(0,255,0));
                        //merchantText.setTextColor(Color.rgb(0,255,0));
                    } else{
                        moneyText.setText("Payment Failed of");
                        merchantText.setText("Rs "+moneyPaid+" at "+merchantName) ;

                        failure.setVisibility(View.VISIBLE);
                        //moneyText.setTextColor(Color.rgb(255,0,0));
                        //merchantText.setTextColor(Color.rgb(255,0,0));
                    }
                } catch(Exception e){
                    Log.d("PaymentPage() : except",e.toString(),e) ;
                    moneyText.setText("Payment Failed of");
                    merchantText.setText("Rs "+moneyPaid+" at "+merchantName) ;

                    moneyText.setTextColor(Color.rgb(255,0,0));
                    merchantText.setTextColor(Color.rgb(255,0,0));
                }
            }
        },100) ;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                moneyText.setVisibility(View.VISIBLE);
                merchantText.setVisibility(View.VISIBLE);
            }
        },200) ;


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String noAdult = getIntent().getExtras().getString("noAdult") ;
                String noKid = getIntent().getExtras().getString("noKid") ;

                Intent myIntent = new Intent(PaymentPage.this, FinalTicket.class);
                myIntent.putExtra("ttl", moneyPaid); //Optional parameter
                myIntent.putExtra("ad", noAdult);
                myIntent.putExtra("kid", noKid);
                PaymentPage.this.startActivity(myIntent);

               // finish();
            }
        },3000) ;



    }

    private class MyTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... args) {
            Log.d("mVisa() ","Creating request object") ;
            OkHttpClient client = new OkHttpClient() ;
            Gson gson = new Gson();
            Request request = new Request.Builder()
                    .url(SERVICE_ENDPOINT)
                    .header("Accept","application/json,application/octet-stream")
                    .header("Content-Type","application/json")
                    .post(RequestBody.create(JSON, VISAPAYLOAD.mVisapayLoad))
                    .build() ;
            try{
                Log.d("mVisa() ","Requesting mVisa API:"+request.toString()) ;
                Response response = client.newCall(request).execute() ;
                Log.d("mVisa() ","Request Completed with Response Object: "+response) ;

                String res = response.body().string();

                Log.d("mVisa() ","Processing Result: "+res) ;
                JsonElement jelement = new JsonParser().parse(res);
                JsonObject jobject = jelement.getAsJsonObject();
                jobject = jobject.getAsJsonObject("body");
                String result = jobject.get("actionCode").toString().replaceAll("\"","");
                Log.d("mVIsa() : actionCode: ",result) ;
                if(Integer.parseInt(result)==0){
                    return "success" ;
                }
            } catch(Exception e){
                Log.d("mVisa():Exception ",e.toString(),e) ;
            }
            return "failed" ;
        }
    }


}
