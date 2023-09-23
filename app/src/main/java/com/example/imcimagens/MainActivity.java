package com.example.imcimagens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextHeight, editTextWeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = Double.parseDouble(editTextHeight.getText().toString());
                double weight = Double.parseDouble(editTextWeight.getText().toString());

                double bmi = calculateBMI(height, weight);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("BMI", bmi);
                startActivity(intent);
            }
        });
    }

    private double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }
}
