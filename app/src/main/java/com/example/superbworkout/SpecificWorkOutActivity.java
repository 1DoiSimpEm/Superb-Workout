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
import android.widget.ProgressBar;
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
    static final long START_TIME_INT_MILIS = 6000;
    long mTimeLeftInMillis = START_TIME_INT_MILIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: set init
        Intent intent = getIntent();
        button_value = intent.getStringExtra("value");
        int intValue = Integer.valueOf(button_value);
        //TODO: content view stuff
        switch (intValue) {
            case 1:
                setContentView(R.layout.activity_workout1);
                initVideo("lvaQcFaxL00");
                timerInit();
                break;
            case 2:
                setContentView(R.layout.activity_workout2);
                initVideo("Xyd_fa5zoEU");
                timerInit();
                break;
            case 3:
                setContentView(R.layout.activity_workout3);
                initVideo("dl8_opV0A0Y");
                timerInit();
                break;
            case 4:
                setContentView(R.layout.activity_workout4);
                initVideo("dl8_opV0A0Y");
                timerInit();
                break;
            case 5:
                setContentView(R.layout.activity_workout5);
                initVideo("dl8_opV0A0Y");
                timerInit();
                break;
            case 6:
                setContentView(R.layout.activity_workout6);
                initVideo("dl8_opV0A0Y");
                timerInit();
                break;
            case 7:
                setContentView(R.layout.activity_workout7);
                initVideo("GN8EA9mpkdY");
                timerInit();
                break;
            case 8:
                setContentView(R.layout.activity_workout8);
                initVideo("GN8EA9mpkdY");
                timerInit();
                break;
            case 9:
                setContentView(R.layout.activity_workout9);
                initVideo("GN8EA9mpkdY");
                timerInit();
                break;
            case 10:
                setContentView(R.layout.activity_workout10);
                initVideo("GN8EA9mpkdY");
                timerInit();
                break;
        }
    }

    private void initVideo(String vidSource) {
        //TODO: set video
        btn_play = findViewById(R.id.play);
        youTubePlayerView = findViewById(R.id.YouTubePlayerView);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(vidSource);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(SpecificWorkOutActivity.this, "CAN'T LOAD VIDEO", Toast.LENGTH_LONG).show();
                btn_play.setVisibility(View.VISIBLE);
            }
        };
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize("AIzaSyBmCZcbsTG_oRapQY_umryk5-Ses6dBQXs", onInitializedListener);
                btn_play.setVisibility(View.INVISIBLE);
            }
        });
    }

    //TODO: timer configuration
    private void timerInit() {
        mTextViewCountDown = findViewById(R.id.timerTextView);
        mButtonStartPause = findViewById(R.id.startTimer);
        mButtonReset = findViewById(R.id.resetTimer);
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


    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormat = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormat);

    }

}