package com.example.superbworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.security.Key;
import java.util.Locale;

public class SpecificWorkOutActivity extends YouTubeBaseActivity {
    private String button_value;
    Button btn_play;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    //timer variables
    TextView mTextViewCountDown;
    Button mButtonStartPause, mButtonReset;
    CountDownTimer mCountDownTimer;
    boolean mTimerRunning;
    static final long START_TIME_INT_MILIS = 600000;
    long mTimeLeftInMillis = START_TIME_INT_MILIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: set init
        Intent intent = getIntent();
        button_value = intent.getStringExtra("value");
        int intValue = Integer.valueOf(button_value);
        mTextViewCountDown = findViewById(R.id.timerTextView);
        mButtonStartPause = findViewById(R.id.startTimer);
        mButtonReset = findViewById(R.id.resetTimer);


        //TODO: content view stuff
        switch (intValue) {
            case 1:
                setContentView(R.layout.activity_workout1);
                initVideo("lvaQcFaxL00");
                break;
            case 2:
                setContentView(R.layout.activity_workout2);
                initVideo("asdas");
                break;
            case 3:
                setContentView(R.layout.activity_workout3);
                break;
            case 4:
                setContentView(R.layout.activity_workout4);
                break;
            case 5:
                setContentView(R.layout.activity_workout5);
                break;
            case 6:
                setContentView(R.layout.activity_workout6);
                break;
            case 7:
                setContentView(R.layout.activity_workout7);
                break;
            case 8:
                setContentView(R.layout.activity_workout8);
                break;
            case 9:
                setContentView(R.layout.activity_workout9);
                break;
            case 10:
                setContentView(R.layout.activity_workout10);
                break;
        }
    }

    public void initVideo(String vidSource) {
        //TODO: set video
        btn_play = findViewById(R.id.play);
        youTubePlayerView = findViewById(R.id.YouTubePlayerView);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(vidSource);
                Toast.makeText(SpecificWorkOutActivity.this, "VIDEO LOADED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(SpecificWorkOutActivity.this, "CAN'T LOAD VIDEO", Toast.LENGTH_LONG).show();
            }
        };
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize("AIzaSyBmCZcbsTG_oRapQY_umryk5-Ses6dBQXs", onInitializedListener);
            }
        });
    }

    //TODO: timer configuration
    public void timerInit() {
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonReset.setVisibility(View.VISIBLE);
                mButtonStartPause.setVisibility(View.INVISIBLE);

            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.INVISIBLE);


    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }


    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_INT_MILIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }


    public void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormat);
    }

}