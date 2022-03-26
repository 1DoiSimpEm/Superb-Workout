package com.example.superbworkout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MealActivity extends AppCompatActivity
{
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager,viewPager2;
    Adapter adapter,adapter2;
    List<Food> foods,foods2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.routine);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.routine:
                        return true;
                    case R.id.info:
                        startActivity(new Intent(getApplicationContext(), About.class));
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        return true;
                }
                return false;
            }
        });


        foods = new ArrayList<>();
        foods.add(new Food(R.drawable.eat1, "PB&J", "The bread and jelly in this lunchbox staple serve up the carbs. They give you the energy your muscles need during exercise. The peanut butter adds a dose of protein, which helps you feel full, and that can help fend off post-workout cravings and binges. In fact, research shows that eating small amounts of peanuts can help you maintain a healthy weight. Headed on an easy walk or to yoga class? Half a sandwich may be all you need."));
        foods.add(new Food(R.drawable.eat2, "Oatmeal with Low-Fat Milk and Fruit", "Do you work out in the morning? Start your day with a bowl of high-fiber, whole grain oatmeal and fruit. Your body digests the carbs in this combo more slowly, so your blood sugar stays steadier. You’ll feel energized for longer. For an extra dose of protein and bone-building calcium, stir in some low-fat milk."));
        foods.add(new Food(R.drawable.eat3, "Fruit-and-Yogurt Smoothie", "Smoothies are easy to digest, so you won’t feel sluggish during your workout. But many store-bought versions are high in added sugar. Whip up your own version with protein-rich yogurt and fruit, which packs in energy-boosting carbs. Blend it with water or ice to help you stay hydrated. Research shows that not getting enough fluids can zap your strength and endurance."));
        foods.add(new Food(R.drawable.eat4, "Trail Mix", "It’s known as a hiking staple, but trail mix is a good snack for any workout. Raisins give you a quick hit of energy that’s easy on the stomach. Mix a small handful of them with a few almonds, which are high in protein and heart-healthy unsaturated fat. They also have an antioxidant that may help your body use oxygen better -- and give you better exercise results."));
        adapter = new Adapter(foods, this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(20, 0, 20, 0);
        foods2 = new ArrayList<>();
        foods2.add(new Food(R.drawable.steak1, "Juicy Steak", "Very expensive."));
        foods2.add(new Food(R.drawable.steak2, "Juicy Steak", "Very expensive."));
        adapter2 = new Adapter(foods2,this);
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setAdapter(adapter2);
        viewPager2.setPadding(20, 0, 20, 0);














    }
}


