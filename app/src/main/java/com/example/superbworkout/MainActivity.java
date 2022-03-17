package com.example.superbworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_start1, button_start2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiation();
        setOnClick();

    }

    public void startWorkout(View view) {
        Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
        startActivity(intent);
    }

    public void startMeal(View view) {
        Intent intent = new Intent(MainActivity.this, MealActivity.class);
        startActivity(intent);
    }


    private void setOnClick() {
        button_start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWorkout(view);
            }
        });
        button_start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMeal(view);
            }
        });
    }

    private void initiation() {
        button_start1 = findViewById(R.id.button_start1);
        button_start2 = findViewById(R.id.button_start2);
    }


}