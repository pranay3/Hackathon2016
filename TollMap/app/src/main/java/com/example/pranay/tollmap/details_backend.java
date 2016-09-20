package com.example.pranay.tollmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by pranay on 19/09/16.
 */
public class details_backend extends AppCompatActivity {
    private static final int START_PLACE_PICKER_REQUEST = 1;
    private static final int END_PLACE_PICKER_REQUEST = 2;
    private EditText startText;
    private EditText endText;
    private LatLng startPoint;
    private LatLng endPoint;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        startText = (EditText) findViewById(R.id.editText);
        endText = (EditText) findViewById(R.id.editText2);
        startText.setInputType(InputType.TYPE_NULL);
        endText.setInputType(InputType.TYPE_NULL);
        Button letsToll=(Button) findViewById(R.id.button);
        startText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PlacePicker.IntentBuilder intentBuilder =
                            new PlacePicker.IntentBuilder();

                    startActivityForResult(intentBuilder.build(details_backend.this), START_PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException
                        | GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        endText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PlacePicker.IntentBuilder intentBuilder =
                            new PlacePicker.IntentBuilder();

                    startActivityForResult(intentBuilder.build(details_backend.this), END_PLACE_PICKER_REQUEST);

                } catch (GooglePlayServicesRepairableException
                        | GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
        letsToll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startPoint==null || endPoint==null){
                    Toast.makeText(details_backend.this,"Please select both start and end points",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent myIntent = new Intent(details_backend.this, RouteActivity.class);
                    myIntent.putExtra("start", startPoint); //Optional parameters
                    myIntent.putExtra("end", endPoint);
                    details_backend.this.startActivity(myIntent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {

            final Place place = PlacePicker.getPlace(this, data);
            final CharSequence name = place.getName();
            final CharSequence address = place.getAddress();
            String attributions = (String) place.getAttributions();
            if (attributions == null) {
                attributions = "";
            }

            if(requestCode == START_PLACE_PICKER_REQUEST) {
                startPoint=place.getLatLng();
                startText.setText(address);
            }
            else if (requestCode == END_PLACE_PICKER_REQUEST){
                endPoint=place.getLatLng();
                endText.setText(address);
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
