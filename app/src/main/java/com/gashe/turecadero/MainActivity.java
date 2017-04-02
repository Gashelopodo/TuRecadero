package com.gashe.turecadero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String response = null;

        // Cargamos recados del usuario
        GetRecados getRecados = new GetRecados(this);
        getRecados.execute();

    }

    public void getRecadosToString(String jsonString){

        Gson gson = new Gson();
        ArrayList<Recado> recados =  gson.fromJson(jsonString, new TypeToken<ArrayList<Recado>>() {}.getType());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        ListRecadosAdapter listRecadosAdapter = new ListRecadosAdapter(recados);
        recyclerView.setAdapter(listRecadosAdapter);

    }

}
