package com.example.day20.ui;

import android.app.Application;
import android.content.Context;

/**
 * 作者：恆亙
 * 时间：2019/9/24
 * 功能：
 **/
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
