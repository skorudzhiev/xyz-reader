package com.example.xyzreader.remote;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static MyApplication instance;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        context = getApplicationContext();
    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }

    public static Context getContext(){
        return context;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
