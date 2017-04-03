package com.gashe.turecadero.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.gashe.turecadero.listeners.ButtonListener;
import com.gashe.turecadero.R;
import com.gashe.turecadero.models.Recado;
import com.gashe.turecadero.utils.Utils;

import java.util.Calendar;

public class DetalleRecadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_recado);

        Intent intent = getIntent();
        Recado recado = (Recado) intent.getSerializableExtra("recado");


        Utils utils = new Utils();

        Calendar calendar = utils.toCalendar(recado.getFecha_hora());
        Calendar calendar1 = utils.toCalendar(recado.getFecha_hora_maxima());
        String hour = ((calendar.get(Calendar.HOUR) > 9) ? "" + calendar.get(Calendar.HOUR) : "0" + calendar.get(Calendar.HOUR));
        String hour1 = ((calendar1.get(Calendar.HOUR) > 9) ? "" + calendar1.get(Calendar.HOUR) : "0" + calendar1.get(Calendar.HOUR));
        String minute = ((calendar.get(Calendar.MINUTE) > 9) ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE));
        String minute1 = ((calendar1.get(Calendar.MINUTE) > 9) ? "" + calendar1.get(Calendar.MINUTE) : "0" + calendar1.get(Calendar.MINUTE));


        TextView clientName = (TextView)findViewById(R.id.clientName);
        TextView phoneClient = (TextView)findViewById(R.id.clientPhone);
        TextView recogidaText = (TextView)findViewById(R.id.recogidaText);
        TextView entregaText = (TextView)findViewById(R.id.entregaText);
        TextView horaRecogida = (TextView)findViewById(R.id.horaRecogida);
        TextView horaEntrega = (TextView)findViewById(R.id.horaEntrega);
        TextView descriptionText = (TextView)findViewById(R.id.descriptionText);

        clientName.setText(recado.getNombre_cliente());
        phoneClient.setText(recado.getTelefono());
        recogidaText.setText(recado.getDireccion_recogida());
        entregaText.setText(recado.getDireccion_entrega());
        horaRecogida.setText(hour + ":" + minute);
        horaEntrega.setText(hour1 + ":" + minute1);
        descriptionText.setText(recado.getDescripcion());

        Button button = (Button)findViewById(R.id.buttonRealizado);
        button.setOnClickListener(new ButtonListener(this, recado));

    }
}
