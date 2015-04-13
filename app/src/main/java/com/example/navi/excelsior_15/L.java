package com.example.navi.excelsior_15;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Navi on 3/4/2015.
 */
public class L {
    public static void m(String message){
        Log.d("NAVI", "" + message);
    }
    public static void t(Context context, String message) {
        Toast.makeText(context, message + "", Toast.LENGTH_SHORT).show();
    }
}
