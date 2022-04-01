package com.example.superbworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    CardView button_start1, button_start2;
    BottomNavigationView  bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiation();

    }



    public void startWorkout(View view) {
        Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
        startActivity(intent);

    }

    public void startMeal(View view) {
        Intent intent = new Intent(MainActivity.this, RoutineActivity.class);
        startActivity(intent);
    }


    private void initiation() {
     button_start1 = findViewById(R.id.cardview_excersise);
     button_start1.setOnClickListener(view -> startWorkout(view));
        button_start2 = findViewById(R.id.cardview_routine);
        button_start2.setOnClickListener(view -> startMeal(view));
        bottomNavigationView =findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.routine:
                    startActivity(new Intent(getApplicationContext(),MealActivity.class));
                    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    return true;
                case R.id.info:
                    startActivity(new Intent(getApplicationContext(),About.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    return true;
                case R.id.home:
                    return true;
            }
            return false;
        });




    }

}