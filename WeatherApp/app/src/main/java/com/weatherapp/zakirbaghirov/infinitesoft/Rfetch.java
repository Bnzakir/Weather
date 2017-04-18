package com.weatherapp.zakirbaghirov.infinitesoft;

/**
 * Created by zakirbaghirov on 22/02/2017.
 */


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


class Rfetch extends  AsyncTask <String,Void,String> {
    public static String result = null;

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        HttpURLConnection connection = null;
        result=null;

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+URLEncoder.encode(params[0], "UTF-8")+"&APPID=e2c860d4d449666b37b3386ffbf6629c");
            connection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line;

            while ((line = bufferedReader.readLine()) != null)
                result += line;
            in.close();
            return result;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if (result.equals(null))
            return "";

        }
        finally {
            if(connection!=null)
                connection.disconnect();
        }
        return result;

    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        if (result != null) {
            Log.d("Weather received", result);
        }
    }
}


