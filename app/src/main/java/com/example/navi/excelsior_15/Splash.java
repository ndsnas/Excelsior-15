package com.example.navi.excelsior_15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.daimajia.numberprogressbar.NumberProgressBar;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Navi on 3/4/2015.
 */
public class Splash extends ActionBarActivity {
    private int counter = 0;
    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final NumberProgressBar bnp = (NumberProgressBar)findViewById(R.id.numberbar2);
        counter = 0;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bnp.incrementProgressBy(1);
                        counter ++;
                        if (counter == 110) {

                            startActivity(new Intent(Splash.this, MainActivity.class));
                        }
                    }
                });
            }
        }, 1000, 100);

    }



    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        finish();
    }
}
