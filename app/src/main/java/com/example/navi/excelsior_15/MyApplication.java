package com.example.navi.excelsior_15;

import android.app.Application;
import android.content.Context;

/**
 * Created by Navi on 3/3/2015.
 */
public class MyApplication extends Application {
    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }
    public static MyApplication getsInstance(){
        return sInstance;
    }
    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
