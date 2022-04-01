package com.example.superbworkout;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
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
    MediaPlayer ringPlayer;
    CardView timer_cardview;
    //second timer variable

    int myProgress = 0;
    ProgressBar progressBarView;
    Button btn_start;
    TextView tv_time;
    int progress;
    CountDownTimer countDownTimer;
    int endTime = 250;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: set init
        Intent intent = getIntent();
        button_value = intent.getStringExtra("value");
        int intValue = Integer.valueOf(button_value);
        ringPlayer=MediaPlayer.create(this,R.raw.ring);
        timer_cardview=findViewById(R.id.timer_cardview);
        //TODO: content view stuff
        switch (intValue) {
            case 1:
                setContentView(R.layout.activity_workout1);
                initVideo("lvaQcFaxL00");
                timerInit("60");
                break;
            case 2:
                setContentView(R.layout.activity_workout2);
                initVideo("Xyd_fa5zoEU");
                timerInit("60");
                break;
            case 3:
                setContentView(R.layout.activity_workout3);
                initVideo("dl8_opV0A0Y");
                timerInit("60");
                break;
            case 4:
                setContentView(R.layout.activity_workout4);
                initVideo("dl8_opV0A0Y");
                timerInit("60");
                break;
            case 5:
                setContentView(R.layout.activity_workout5);
                initVideo("dl8_opV0A0Y");
                timerInit("60");
                break;
            case 6:
                setContentView(R.layout.activity_workout6);
                initVideo("dl8_opV0A0Y");
                timerInit("60");
                break;
            case 7:
                setContentView(R.layout.activity_workout7);
                initVideo("GN8EA9mpkdY");
                timerInit("60");
                break;
            case 8:
                setContentView(R.layout.activity_workout8);
                initVideo("GN8EA9mpkdY");
                timerInit("60");
                break;
            case 9:
                setContentView(R.layout.activity_workout9);
                initVideo("GN8EA9mpkdY");
                timerInit("60");
                break;
            case 10:
                setContentView(R.layout.activity_workout10);
                initVideo("GN8EA9mpkdY");
                timerInit("60");
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
    private void timerInit(String times)
    {

        progressBarView = (ProgressBar) findViewById(R.id.view_progress_bar);
        btn_start = (Button)findViewById(R.id.btn_start);
        tv_time= (TextView)findViewById(R.id.tv_timer);



        /*Animation*/
        RotateAnimation makeVertical = new RotateAnimation(0, -90, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        makeVertical.setFillAfter(true);
        progressBarView.startAnimation(makeVertical);
        progressBarView.setSecondaryProgress(endTime);
        progressBarView.setProgress(0);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn_countdown(times);
                btn_start.setVisibility(View.INVISIBLE);
            }
        });
    }
    private void fn_countdown(String times) {
            String timeInterval = times;
            progress = 1;
            endTime = Integer.parseInt(timeInterval); // up to finish time

            countDownTimer = new CountDownTimer(endTime * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    setProgress(progress, endTime);
                    progress = progress + 1;
                    int seconds = (int) (millisUntilFinished / 1000) % 60;
                    int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                    int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                    String newtime = hours + ":" + minutes + ":" + seconds;

                    if (newtime.equals("0:0:0")) {
                        tv_time.setText("00:00:00");
                    } else if ((String.valueOf(hours).length() == 1) && (String.valueOf(minutes).length() == 1) && (String.valueOf(seconds).length() == 1)) {
                        tv_time.setText("0" + hours + ":0" + minutes + ":0" + seconds);
                    } else if ((String.valueOf(hours).length() == 1) && (String.valueOf(minutes).length() == 1)) {
                        tv_time.setText("0" + hours + ":0" + minutes + ":" + seconds);
                    } else if ((String.valueOf(hours).length() == 1) && (String.valueOf(seconds).length() == 1)) {
                        tv_time.setText("0" + hours + ":" + minutes + ":0" + seconds);
                    } else if ((String.valueOf(minutes).length() == 1) && (String.valueOf(seconds).length() == 1)) {
                        tv_time.setText(hours + ":0" + minutes + ":0" + seconds);
                    } else if (String.valueOf(hours).length() == 1) {
                        tv_time.setText("0" + hours + ":" + minutes + ":" + seconds);
                    } else if (String.valueOf(minutes).length() == 1) {
                        tv_time.setText(hours + ":0" + minutes + ":" + seconds);
                    } else if (String.valueOf(seconds).length() == 1) {
                        tv_time.setText(hours + ":" + minutes + ":0" + seconds);
                    } else {
                        tv_time.setText(hours + ":" + minutes + ":" + seconds);
                    }

                }

                @Override
                public void onFinish() {
                    setProgress(progress, endTime);
                    btn_start.setVisibility(View.VISIBLE);
                    ringPlayer.start();

                }
            };
            countDownTimer.start();
    }



    public void setProgress(int startTime, int endTime) {
        progressBarView.setMax(endTime);
        progressBarView.setSecondaryProgress(endTime);
        progressBarView.setProgress(startTime);

    }
}