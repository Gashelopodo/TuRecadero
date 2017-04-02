package com.gashe.turecadero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos el JSON de recados del usuario
        GetRecados getRecados = new GetRecados(this);
        getRecados.execute();

    }

    public void getRecadosToString(String jsonString){


        // Convertimos a clase Recado el string JSON
        Gson gson = new Gson();
        ArrayList<Recado> recados =  gson.fromJson(jsonString, new TypeToken<ArrayList<Recado>>() {}.getType());

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

}
