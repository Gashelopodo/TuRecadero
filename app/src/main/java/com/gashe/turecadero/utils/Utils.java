package com.gashe.turecadero.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ProgressBar;

import com.gashe.turecadero.R;
import com.gashe.turecadero.models.Recado;
import com.gashe.turecadero.activities.MainActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Gashe on 2/4/17.
 */

public class Utils {

    public void hideLoader(Activity activity){
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.myLoader);
        progressBar.setVisibility(View.GONE);
    }

    public Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public void resetData(Context context, ArrayList<Recado> recados){
        final SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("control", false);
        for(int i = 0; i < recados.size(); i++){
            editor.putBoolean("realizado" + i, false);
        }
        editor.commit();

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

}
