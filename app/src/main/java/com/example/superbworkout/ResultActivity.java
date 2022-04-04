package com.example.superbworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

class Category {

    public String getCategory (float result) {
        String category;
        if (result < 15) {
            category = "very severely underweight";
        } else if (result >=15 && result <= 16) {
            category = "severely underweight";
        } else if (result >16 && result <= 18.5) {
            category = "underweight";
        } else if (result >18.5 && result <= 25) {
            category = "normal (healthy weight)";
        } else if (result >25 && result <= 30) {
            category = "overweight";
        } else if (result >30 && result <= 35) {
            category = "moderately obese";
        } else if (result >35 && result <= 40) {
            category = "severely obese";
        } else {
            category ="very severely obese";
        }
        return category;
    }
}
class Condition {

    public String getCategory (float result) {
        String category;
        if (result < 15) {
            category = "Severe Thinness";
        } else if (result >=15 && result <= 16) {
            category = "Moderate Thinness";
        } else if (result >16 && result <= 18.5) {
            category = "Mild Thinness";
        } else if (result >18.5 && result <= 25) {
            category = "Normal";
        } else if (result >25 && result <= 30) {
            category = "Overweight";
        } else if (result >30 && result <= 35) {
            category = "Obese Class I";
        } else if (result >35 && result <= 40) {
            category = "Obese Class II";
        } else {
            category ="Obese Class III";
        }
        return category;
    }

}
public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();

        float BMI  = intent.getFloatExtra("BMI", 0);
        String age_value = intent.getStringExtra("age");

        TextView your_bmi = findViewById(R.id.your_bmi);
        your_bmi.setText(String.valueOf(BMI));

        TextView age = findViewById(R.id.age);
        age.setText(age_value);

        TextView category = findViewById(R.id.category);
        Category category1 = new Category();
        category.setText(category1.getCategory(BMI));

        TextView condition = findViewById(R.id.condition);
        Condition condition1 = new Condition();
        condition.setText(condition1.getCategory(BMI));

        Button recalculate = findViewById(R.id.recalculate);
        recalculate.setOnClickListener(v -> updateUI());

    }

    private void updateUI() {
        Intent intent1 = new Intent(ResultActivity.this,RoutineActivity.class);
        startActivity(intent1);
        fileList();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        updateUI();
    }
}