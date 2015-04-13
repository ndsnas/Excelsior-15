package com.example.navi.excelsior_15;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Navi on 3/4/2015.
 */
public class AboutUs extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);

        Toast toast= Toast.makeText(getApplicationContext(), "Its About Us!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
