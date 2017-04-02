package com.gashe.turecadero;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Gashe on 2/4/17.
 */

public class ListRecadosAdapter extends RecyclerView.Adapter<ListRecadosViewHolder> {

    private ArrayList<Recado> recados;

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
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recado_row, parent, false);
        listRecadosViewHolder = new ListRecadosViewHolder(view);
        return listRecadosViewHolder;
    }

    @Override
    public void onBindViewHolder(ListRecadosViewHolder holder, int position) {
        Recado recado = recados.get(position);
        holder.loadDataHolder(recado);
    }
}
