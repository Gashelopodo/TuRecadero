package com.gashe.turecadero.listeners;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import com.gashe.turecadero.R;
import com.gashe.turecadero.activities.DetalleRecadoActivity;
import com.gashe.turecadero.activities.MainActivity;
import com.gashe.turecadero.models.Recado;

/**
 * Created by Gashe on 2/4/17.
 */

public class ButtonListener implements View.OnClickListener {

    private Context context;
    private Recado recado;

    public ButtonListener(Context context) {
        this.context = context;
    }

    public ButtonListener(Context context, Recado recado) {
        this.context = context;
        this.recado = recado;
    }

    @Override
    public void onClick(View view) {

        Intent intent;
        final SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);

        switch (view.getId()){

            case R.id.buttonRecado:
                intent = new Intent(context, DetalleRecadoActivity.class);
                intent.putExtra("recado", recado);
                context.startActivity(intent);
                break;
            case R.id.buttonRealizado:
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("realizado" + recado.getPosition(), true);
                editor.putBoolean("control", true);
                editor.commit();
                intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                break;

        }


    }


}
