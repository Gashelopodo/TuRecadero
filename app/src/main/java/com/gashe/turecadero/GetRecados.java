package com.gashe.turecadero;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Gashe on 2/4/17.
 */

public class GetRecados extends AsyncTask<Void, Void, String> {

    private String URL_GET_RECADOS = "http://elrecadero-ebtm.rhcloud.com/ObtenerListaRecados";
    private Context context;

    public GetRecados(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String response = null;
        URL url = null;
        HttpURLConnection http = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            url = new URL(URL_GET_RECADOS);
            http = (HttpURLConnection)url.openConnection();
            if(http.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = http.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                response = bufferedReader.readLine();
            }
        } catch (Throwable t) {
            Log.d(getClass().getCanonicalName(), "Error: " + t);
        }finally {
            http.disconnect();
        }


        return response;
    }

    @Override
    protected void onPostExecute(String s) {

        Log.d(getClass().getCanonicalName(), "JSON: " + s );

        Activity activity = (Activity) context;
        MainActivity mainActivity = (MainActivity) context;

        Utils utils = new Utils();
        utils.hideLoader(activity);

        mainActivity.getRecadosToString(s);

        super.onPostExecute(s);
    }

}
