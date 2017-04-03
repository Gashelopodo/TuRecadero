package com.gashe.turecadero.viewholders;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gashe.turecadero.listeners.ButtonListener;
import com.gashe.turecadero.R;
import com.gashe.turecadero.models.Recado;
import com.gashe.turecadero.utils.Utils;

import java.util.Calendar;

/**
 * Created by Gashe on 2/4/17.
 */

public class ListRecadosViewHolder extends RecyclerView.ViewHolder {

    private TextView dayName;
    private TextView numDay;
    private TextView hoursText;
    private TextView descriptionText;
    private LinearLayout linearLayout;
    private Context context;

    public ListRecadosViewHolder(View itemView) {
        super(itemView);
        dayName = (TextView) itemView.findViewById(R.id.dayName);
        numDay = (TextView) itemView.findViewById(R.id.numDay);
        hoursText = (TextView) itemView.findViewById(R.id.hoursText);
        descriptionText = (TextView) itemView.findViewById(R.id.descriptionText);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.buttonRecado);
        context = itemView.getContext();
    }

    public void loadDataHolder(Recado recado){

        String[] days = { "", "D", "L", "M", "X", "J", "V", "S" };
        Utils utils = new Utils();

        Calendar calendar = utils.toCalendar(recado.getFecha_hora());
        Calendar calendar1 = utils.toCalendar(recado.getFecha_hora_maxima());
        String hour = ((calendar.get(Calendar.HOUR) > 9) ? "" + calendar.get(Calendar.HOUR) : "0" + calendar.get(Calendar.HOUR));
        String hour1 = ((calendar1.get(Calendar.HOUR) > 9) ? "" + calendar1.get(Calendar.HOUR) : "0" + calendar1.get(Calendar.HOUR));
        String minute = ((calendar.get(Calendar.MINUTE) > 9) ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE));
        String minute1 = ((calendar1.get(Calendar.MINUTE) > 9) ? "" + calendar1.get(Calendar.MINUTE) : "0" + calendar1.get(Calendar.MINUTE));

        dayName.setText("" + days[calendar.get(Calendar.DAY_OF_WEEK)]);
        numDay.setText("" + calendar.get(Calendar.DATE));
        hoursText.setText(hour + ":" + minute + " > " + hour1 + ":" + minute1);
        descriptionText.setText("“"+recado.getDescripcion()+"”");

        if(recado.isRealizado()) linearLayout.setBackgroundColor(Color.CYAN);

        linearLayout.setOnClickListener(new ButtonListener(context, recado));

    }


}
