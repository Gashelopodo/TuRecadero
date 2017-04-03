package com.gashe.turecadero.http;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.gashe.turecadero.activities.MainActivity;
import com.gashe.turecadero.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

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
                inputStreamReader = new InputStreamReader(inputStream, Charset.forName("ISO-8859-15"));
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

        // guardamos json en prefs
        final SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("recados", s);
        editor.commit();

        Activity activity = (Activity) context;
        MainActivity mainActivity = (MainActivity) context;

        Utils utils = new Utils();
        utils.hideLoader(activity);

        mainActivity.getRecadosToString(s);

        super.onPostExecute(s);
    }

}
