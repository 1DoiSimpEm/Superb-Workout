package com.example.superbworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.security.Key;

public class SpecificWorkOutActivity extends YouTubeBaseActivity {
    private  String button_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_work_out);
        //TODO: set init
        Intent intent =getIntent();
        button_value=intent.getStringExtra("value");
        int intValue=Integer.valueOf(button_value);
        //TODO: content view stuff
        switch (intValue)
        {
            case 1:
                setContentView(R.layout.activity_workout1);
                initVideo("lvaQcFaxL00");
                break;
            case 2:
                setContentView(R.layout.activity_workout2);
                initVideo("IHHQm4MeoV0");
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



    public void initVideo(String vidSource)
    {
        //TODO: set video
        Button btn_play;
        YouTubePlayerView youTubePlayerView;
        YouTubePlayer.OnInitializedListener onInitializedListener;
        btn_play=findViewById(R.id.play);
        youTubePlayerView = findViewById(R.id.YouTubePlayerView);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(vidSource);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize("AIzaSyBmCZcbsTG_oRapQY_umryk5-Ses6dBQXs",onInitializedListener);
            }
        });
    }
}