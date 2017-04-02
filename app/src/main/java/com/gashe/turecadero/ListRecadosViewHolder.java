package com.gashe.turecadero;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Gashe on 2/4/17.
 */

public class ListRecadosViewHolder extends RecyclerView.ViewHolder {

    private TextView clientName;
    private TextView clientPhone;
    private TextView recogidaText;
    private TextView entregaText;
    private TextView dateText;
    private TextView descriptionText;

    public ListRecadosViewHolder(View itemView) {
        super(itemView);
        clientName = (TextView) itemView.findViewById(R.id.clientName);
        clientPhone = (TextView) itemView.findViewById(R.id.clientPhone);
        recogidaText = (TextView) itemView.findViewById(R.id.recogidaText);
        entregaText = (TextView) itemView.findViewById(R.id.entregaText);
        dateText = (TextView) itemView.findViewById(R.id.dateText);
        descriptionText = (TextView) itemView.findViewById(R.id.descriptionText);
    }

    public void loadDataHolder(Recado recado){
        clientName.setText(recado.getNombre_cliente());
        clientPhone.setText(recado.getTelefono());
        recogidaText.setText(recado.getDireccion_recogida());
        entregaText.setText(recado.getDireccion_entrega());
        dateText.setText(recado.getFecha_hora().toString() + " / " + recado.getFecha_hora_maxima().toString() );
        descriptionText.setText(recado.getDescripcion());
    }



}
