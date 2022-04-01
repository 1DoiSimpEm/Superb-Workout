package com.example.superbworkout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class About extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView fb_link,discord_link,git_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        fb_link=findViewById(R.id.fb_link);
        discord_link=findViewById(R.id.discord_link);
        git_link=findViewById(R.id.git_link);
        bottomNavigationView =findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.info);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.routine:
                        startActivity(new Intent(getApplicationContext(),MealActivity.class));
                        return true;
                    case R.id.info:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return true;
                }
                return false;
            }
        });
        discord_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        git_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://github.com/1DoiSimpEm");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        fb_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("https://www.facebook.com/vietpham1705");
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

    }
}