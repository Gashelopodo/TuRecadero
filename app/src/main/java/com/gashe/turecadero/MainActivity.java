package com.gashe.turecadero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargamos recados del usuario
        GetRecados getRecados = new GetRecados(this);
        getRecados.execute();

    }
}
