package com.busradeniz.place_api_sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.busradeniz.place_api_sample.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

/**
 * Created by busradeniz on 26/07/2016.
 */
public class PlacePickerSampleActivity extends AppCompatActivity {

    private static String LOG_TAG = "PlacePickerSampleActivity";
    private static int PLACE_PICKER_REQUEST = 1;

    private TextView txtPlaceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_picker_sample);

        txtPlaceName = (TextView) this.findViewById(R.id.txtPlaceName);
        Button btnSelectPlace = (Button) this.findViewById(R.id.btnSelectPlace);
        btnSelectPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlacePickerView();
            }
        });

    }

    private void openPlacePickerView(){
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                Log.i(LOG_TAG, String.format("Place Name : %s", place.getName()));
                Log.i(LOG_TAG, String.format("Place Address : %s", place.getAddress()));
                Log.i(LOG_TAG, String.format("Place Id : %s", place.getId()));

                txtPlaceName.setText(String.format("Place : %s - %s" , place.getName() , place.getAddress()));
            }
        }
    }

}
