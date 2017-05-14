package com.example.administrator.servicelive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/5/14.
 */

public class MyService extends Service{
    Timer timer;
    TimerTask timerTask;
    int count=0;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
        startTimer();
        return START_STICKY;
    }

    private void startTimer() {
       timer=new Timer();
        initalizeTimerTask();
        timer.schedule(timerTask,1000,1000);
    }
    public void stopTimerTask(){
        if(timer!=null){
            timer.cancel();
            timer=null;
        }
    }

    private void initalizeTimerTask() {
       timerTask=new TimerTask() {
           @Override
           public void run() {
               Log.d("MyService","time:----"+count++);
           }
       };
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //TODO:en
        throw new UnsupportedOperationException("not yet operate");
    }
}
