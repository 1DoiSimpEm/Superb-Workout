package com.example.superbworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SpecificWorkOutActivity extends AppCompatActivity {
    private  String button_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_work_out);


        Intent intent =getIntent();
        button_value=intent.getStringExtra("value");
        int intValue=Integer.valueOf(button_value);
        switch (intValue)
        {
            case 1:
                setContentView(R.layout.activity_workout1);
                break;
            case 2:
                setContentView(R.layout.activity_workout2);
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
}