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
     button_start1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startWorkout(view);
         }
     });
        button_start2 = findViewById(R.id.cardview_routine);
        button_start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMeal(view);
            }
        });
//        pb1=findViewById(R.id.progressBar1);
        bottomNavigationView =findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.routine:
                        startActivity(new Intent(getApplicationContext(),MealActivity.class));
                        return true;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        return true;
                    case R.id.home:
                        return true;
                }
                return false;
            }
        });




    }

}