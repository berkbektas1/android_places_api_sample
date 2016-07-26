package com.busradeniz.place_api_sample.utils;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

/**
 * Created by busradeniz on 26/07/2016.
 */
public class PlaceApiSampleApplication extends Application {

    public static GoogleApiClient googleApiClient;
}
