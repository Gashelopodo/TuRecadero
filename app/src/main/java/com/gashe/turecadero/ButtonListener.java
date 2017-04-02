package com.gashe.turecadero;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

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
        

        switch (view.getId()){

            case R.id.buttonRecado:
                intent = new Intent(context, DetalleRecadoActivity.class);
                intent.putExtra("recado", recado);
                context.startActivity(intent);
                break;
            case R.id.buttonRealizado:

                break;

        }


    }


}
