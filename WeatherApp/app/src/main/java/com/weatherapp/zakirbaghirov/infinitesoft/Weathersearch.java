package com.weatherapp.zakirbaghirov.infinitesoft;

/**
 * Created by zakirbaghirov on 22/02/2017.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class Weathersearch extends Activity    {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weathersearch);
        if (MapsActivity.city == null) {
            Toast.makeText(getApplicationContext(), MapsActivity.city, Toast.LENGTH_LONG).show();
        } else {
            new Rfetch().execute(MapsActivity.city);


            txt1 = (TextView) findViewById(R.id.txt1);
            txt2 = (TextView) findViewById(R.id.txt2);
            txt3 = (TextView) findViewById(R.id.txt3);
            txt4 = (TextView) findViewById(R.id.txt4);
            txt5 = (TextView) findViewById(R.id.txt5);
            txt6 = (TextView) findViewById(R.id.txt6);
            txt7 = (TextView) findViewById(R.id.txt7);
            txt8 = (TextView) findViewById(R.id.txt8);


            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stringWork(Rfetch.result);

        }
    }



    private void stringWork(String result) {
        String city, temp, weatherType1, humidity, pressure, windSpeed, temp_min;

        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        // txt8.setText("");
        //txt8.setText(result);


        if (result != "") {
            city = getBetweenStrings(result, "name\":"
                    , ",\"cod\"");
            txt1.setText("City is: " + city);

            temp = getBetweenStrings(result, "temp\":"
                    , ",\"pressure\"");
            txt2.setText("Temp is: " + temp + " Kelvin");

            weatherType1 = getBetweenStrings(result, "description\":"
                    , ",\"icon\"");
            txt3.setText("Weather type is: " + weatherType1);

            pressure = getBetweenStrings(result, "pressure\":"
                    , ",\"humidity\"");
            txt4.setText("Weather pressure is: " + pressure + " hPa");

            humidity = getBetweenStrings(result, "humidity\":"
                    , ",\"temp_min\"");
            txt5.setText("Weather humidity is: " + humidity + "%");

            windSpeed = getBetweenStrings(result, "speed\":"
                    , ",\"deg\"");
            txt6.setText("Wind speed is: " + windSpeed + " meter/sec");

            temp_min = getBetweenStrings(result, "temp_min\":"
                    , ",\"temp_max\"");
            txt7.setText("Minimum temp is: " + temp_min + " Kelvin");
        }
        else  {Toast.makeText(getApplicationContext(),"No information received please try again",Toast.LENGTH_SHORT).show();
        }
    }


    private String getBetweenStrings(String text, String textFrom, String textTo) {

        String result;

        // Cut the beginning of the text to not occasionally meet a
        // 'textTo' value in it:
        if (text.contains(textFrom)){
            result = text.substring(
                    text.indexOf(textFrom) + textFrom.length(),
                    text.length());

            // Cut the excessive ending of the text:
            result =
                    result.substring(
                            0,
                            result.indexOf(textTo));

            return result;}
        else {
            Toast.makeText(getApplicationContext(),
                    "No information received please try again", Toast.LENGTH_SHORT).show();

            result = "null";
            return result;
        }
    }
    public void Back(View view){


        Intent i = new Intent(Weathersearch.this,MapsActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
        startActivity(i);
        //Weathersearch.this.finish();



    }





}
