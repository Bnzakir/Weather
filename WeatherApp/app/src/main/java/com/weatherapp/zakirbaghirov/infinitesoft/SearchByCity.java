package com.weatherapp.zakirbaghirov.infinitesoft;

/**
 * Created by zakirbaghirov on 22/02/2017.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;


import static android.content.ContentValues.TAG;



public class SearchByCity extends Activity  {
    public static boolean marker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_city);
        marker=false;
        init();
    }

    public  void init(){
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {

                MapsActivity.city=place.getName().toString();
                MapsActivity.ll1= place.getLatLng();
                marker=true;

                Intent intent = new Intent(SearchByCity.this, Weathersearch.class);
                startActivity(intent);
                Log.i(TAG, "Place: " + place.getName());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
    }
    public void Back(View view){


        Intent i = new Intent(SearchByCity.this,MapsActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
        startActivity(i);



    }

}