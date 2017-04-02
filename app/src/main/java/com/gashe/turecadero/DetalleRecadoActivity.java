package com.gashe.turecadero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        clientName.setText(recado.getNombre_cliente());
        TextView phoneClient = (TextView)findViewById(R.id.clientPhone);
        phoneClient.setText(recado.getTelefono());
        TextView recogidaText = (TextView)findViewById(R.id.recogidaText);
        recogidaText.setText(recado.getDireccion_recogida());
        TextView entregaText = (TextView)findViewById(R.id.entregaText);
        entregaText.setText(recado.getDireccion_entrega());
        TextView horaRecogida = (TextView)findViewById(R.id.horaRecogida);
        horaRecogida.setText(hour + ":" + minute);
        TextView horaEntrega = (TextView)findViewById(R.id.horaEntrega);
        horaEntrega.setText(hour1 + ":" + minute1);
        TextView descriptionText = (TextView)findViewById(R.id.descriptionText);
        descriptionText.setText(recado.getDescripcion());

        Button button = (Button)findViewById(R.id.buttonRealizado);
        button.setOnClickListener(new ButtonListener(this, recado));

    }
}
