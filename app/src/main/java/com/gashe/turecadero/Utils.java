package com.gashe.turecadero;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by Gashe on 2/4/17.
 */

public class Utils {

    public void hideLoader(Activity activity){
        ProgressBar progressBar = (ProgressBar) activity.findViewById(R.id.myLoader);
        progressBar.setVisibility(View.GONE);
    }

}
