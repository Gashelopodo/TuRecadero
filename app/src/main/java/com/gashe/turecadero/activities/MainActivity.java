package com.gashe.turecadero.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.gashe.turecadero.utils.CompareDate;
import com.gashe.turecadero.http.GetRecados;
import com.gashe.turecadero.adapters.ListRecadosAdapter;
import com.gashe.turecadero.R;
import com.gashe.turecadero.models.Recado;
import com.gashe.turecadero.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Recado> recados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean control = prefs.getBoolean("control", false);

        if(!control) {
            // Obtenemos el JSON de recados del usuario
            GetRecados getRecados = new GetRecados(this);
            getRecados.execute();
        }else{

            Utils utils = new Utils();
            utils.hideLoader((Activity) this);

            String json = prefs.getString("recados", "");
            getRecadosToString(json);
        }

    }

    public void getRecadosToString(String jsonString){


        // Convertimos a clase Recado el string JSON
        Gson gson = new Gson();
        recados =  gson.fromJson(jsonString, new TypeToken<ArrayList<Recado>>() {}.getType());

        // Ordenamos por fecha
        Collections.sort(recados, new CompareDate());

        // Instanciamos, asignamos adapter y pintamos lista de recados
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        ListRecadosAdapter listRecadosAdapter = new ListRecadosAdapter(recados);
        recyclerView.setAdapter(listRecadosAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, 1, "Resetear datos");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Utils utils = new Utils();
        utils.resetData(this, recados);

        return true;

    }
}
