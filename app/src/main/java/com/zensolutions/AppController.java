package com.zensolutions;

import android.app.Application;
import android.content.Context;

import com.zensolutions.Network.ApiFactory;
import com.zensolutions.Network.RedditService;
import com.zensolutions.Utils.ApiUtils;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;


public class AppController extends Application {
    private RedditService mRedditService;
    private Scheduler mScheduler;

    private static AppController get(Context context){
        return (AppController) context.getApplicationContext();
    }

    public static AppController create (Context context){return AppController.get(context);}

    public RedditService getRedditService() {
        if(mRedditService == null){
            mRedditService= ApiUtils.getSOService();
        }
        return mRedditService;
    }

    public Scheduler subcribeScheduler(){
        if(mScheduler==null){
            mScheduler= Schedulers.io();
        }
        return mScheduler;
    }
}
