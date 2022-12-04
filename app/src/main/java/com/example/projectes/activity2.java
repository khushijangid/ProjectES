package com.example.projectes;


import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;



public class activity2 extends AppCompatActivity {
    int scoreTeamA;
    int scoreTeamB;

    Chronometer chronometer;
    ImageButton btStart, btStop;

    private boolean isResume;
    Handler handler;
    long tMilliSec, tStart, tBuff, tUpdate = 0L;
    int sec,min,milliSec;

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int scoreTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    protected void onCreateA(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        displayForTeamA(0);
    }

    public void scoreThreeA(View view){
        scoreTeamA=scoreTeamA+3;
        displayA(scoreTeamA);
    }
    public void scoreTwoA(View view){
        scoreTeamA=scoreTeamA+2;
        displayA(scoreTeamA);
    }
    public void scoreFreeThrowA(View view){
        scoreTeamA=scoreTeamA+1;
        displayA(scoreTeamA);
    }
    public void displayA (int number){
        TextView countViewer = (TextView)findViewById(R.id.team_a_score);
        countViewer.setText(""+ number);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int scoreTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    protected void onCreateB(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        displayForTeamB(0);
    }
    public void scoreThreeB(View view){
        scoreTeamB=scoreTeamB+3;
        displayB(scoreTeamB);
    }
    public void scoreTwoB(View view){
        scoreTeamB=scoreTeamB+2;
        displayB(scoreTeamB);
    }
    public void scoreFreeThrowB(View view){
        scoreTeamB=scoreTeamB+1;
        displayB(scoreTeamB);
    }
    public void displayB (int number){
        TextView countViewer = (TextView)findViewById(R.id.team_b_score);
        countViewer.setText(""+ number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        btStart= findViewById(R.id.bt_start);
        btStop= findViewById(R.id.bt_stop);

        handler= new Handler();

        btStart.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           if(!isResume) {
                                               tStart = SystemClock.uptimeMillis();
                                               handler.postDelayed(runnable, 0);
                                               chronometer.start();
                                               isResume = true;
                                               btStop.setVisibility(View.GONE);
                                               btStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_pause_24));
                                           }else{
                                               tBuff+= tMilliSec;
                                               handler.removeCallbacks(runnable);
                                               chronometer.stop();
                                               isResume=false;
                                               btStop.setVisibility(View.VISIBLE);
                                               btStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_play_arrow_24));
                                           }

                                       }
                                   }
        );

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isResume){
                    btStart.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_play_arrow_24)
                    );
                    tMilliSec=0L;
                    tStart=0L;
                    tBuff=0L;
                    tUpdate=0L;
                    sec=0;
                    min=0;
                    milliSec=0;
                    chronometer.setText("00:00:00");
                }
            }
        });
    }
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tMilliSec = SystemClock.uptimeMillis() - tStart;
            tUpdate = tBuff + tMilliSec;
            sec= (int) (tUpdate/1000);
            min = sec/60;
            sec= sec%60;
            milliSec= (int) (tUpdate%100);
            chronometer.setText(String.format("%02d", min)+":"+String.format("%02d", sec)+":"+String.format("%02d", milliSec));
            handler.postDelayed(this,60);

        }
    };






        /**
         *  Reset the value of both the Teams.
         */
    public void reset (View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(0);
        displayForTeamB(0);
    }

}