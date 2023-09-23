package com.example.imcimagens;

import android.content.Intent;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        TextView textViewResult = findViewById(R.id.textViewResult);
        TextView textViewCategory = findViewById(R.id.textViewCategory);
        ImageView imageViewCategory = findViewById(R.id.imageViewCategory);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("BMI", 0);

        String bmiCategory = calculateBMICategory(bmi);
        int imageResource = getDrawableResourceByCategory(bmiCategory);

        textViewResult.setText(String.format("Seu IMC é: %.2f", bmi));
        textViewCategory.setText("Categoria: " + bmiCategory);
        imageViewCategory.setImageResource(imageResource);
    }

    private String calculateBMICategory(double bmi) {
        if (bmi < 25.0) {
            return "Adequado";
        } else if (bmi < 30.0) {
            return "Pré-obeso";
        } else if (bmi < 35.0) {
            return "Obesidade grau I";
        } else if (bmi < 40.0) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }

    private int getDrawableResourceByCategory(String category) {
        switch (category) {
            case "Adequado":
                return R.drawable.adequado;
            case "Pré-obeso":
                return R.drawable.pre_obeso;
            case "Obesidade grau I":
                return R.drawable.obesidade_grau_1;
            case "Obesidade grau II":
                return R.drawable.obesidade_grau_2;
            default:
                return R.drawable.obesidade_grau_3;
        }
    }
}
