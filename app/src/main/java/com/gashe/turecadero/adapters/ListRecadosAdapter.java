package com.gashe.turecadero.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gashe.turecadero.viewholders.ListRecadosViewHolder;
import com.gashe.turecadero.R;
import com.gashe.turecadero.models.Recado;

import java.util.ArrayList;

/**
 * Created by Gashe on 2/4/17.
 */

public class ListRecadosAdapter extends RecyclerView.Adapter<ListRecadosViewHolder> {

    private ArrayList<Recado> recados;
    private Context context;

    public ListRecadosAdapter(ArrayList<Recado> recados) {
        this.recados = recados;
    }

    @Override
    public int getItemCount() {
        return recados.size();
    }

    @Override
    public ListRecadosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListRecadosViewHolder listRecadosViewHolder = null;
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_recado, parent, false);
        listRecadosViewHolder = new ListRecadosViewHolder(view);
        return listRecadosViewHolder;
    }

    @Override
    public void onBindViewHolder(ListRecadosViewHolder holder, int position) {

        final SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean realizado = prefs.getBoolean("realizado" + position, false);

            Recado recado = recados.get(position);
            recado.setPosition(position);
            if(realizado) recado.setRealizado(true);
            holder.loadDataHolder(recado);

    }
}
