package vectis.mtgeventcompanion;


import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class CTimer {

    int count;

    Timer timer;
    TimerTask timerTask;

    CTimerListener timerListener;

    public CTimer(int count, CTimerListener timerListener) {

        this.count  = count;
        this.timerListener = timerListener;

        timerTask = new TimerTask() {

            @Override
            public void run() {
                countdown();
            }
        };

        timer = new Timer();
    }


    public CTimer(CTimerListener timerListener) {
         this(100, timerListener);
    }

    public void startTimer(){
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public void pauseTimer(){
        timer.cancel();
    }

    public void stopTimer(){
        timer.cancel();
    }

    public void countdown(){
        this.count--;

        timerListener.countdown(this.count);
        if(this.count <= 0) {
            timerListener.countdownEnded();;
            stopTimer();
        }
    }
}