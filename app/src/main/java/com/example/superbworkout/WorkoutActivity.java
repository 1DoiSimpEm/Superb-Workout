package com.example.superbworkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {

    private int[] poses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
       poses = new int[]
               {
                       R.id.pose1,R.id.pose2,R.id.pose3,R.id.pose4,R.id.pose5,R.id.pose6,R.id.pose7,R.id.pose8,
                       R.id.pose9,R.id.pose10
               };


    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
    public void ImageButtonClicked(View view) {
        for(int i=0;i<poses.length;i++)
        {
            if(view.getId()==poses[i])
            {
                int value=i+1;
                 Intent intent = new Intent(WorkoutActivity.this,SpecificWorkOutActivity.class);
                 intent.putExtra("value",String.valueOf(value));
                 startActivity(intent);
            }
        }
    }
}