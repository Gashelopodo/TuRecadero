package com.gashe.turecadero.utils;

import com.gashe.turecadero.models.Recado;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Gashe on 2/4/17.
 */

public class CompareDate implements Comparator<Recado> {

    @Override
    public int compare(Recado recado, Recado recado2) {

        try {

            Date date = recado.getFecha_hora();
            Date date1 = recado2.getFecha_hora();
            return date.compareTo(date1);

        } catch (Throwable t){
            // error
        }

        return 0;
    }
}
