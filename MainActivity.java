package org.coolstyles.ungdungintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView selectedFoodTextView;
    private TextView selectedDrinkTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedFoodTextView = findViewById(R.id.selectedFoodTextView);
        selectedDrinkTextView = findViewById(R.id.selectedDrinkTextView);

        Button chooseFoodButton = findViewById(R.id.chooseFoodButton);
        Button chooseDrinkButton = findViewById(R.id.chooseDrinkButton);

        chooseFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        chooseDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DrinkActivity.class);
                startActivityForResult(intent, 2);
            }
        });
    }
    public void exitApp(View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                String selectedFood = data.getStringExtra("selectedFood");
                selectedFoodTextView.setText("Bạn chọn món ăn -> " + selectedFood);
            } else if (requestCode == 2) {
                String selectedDrink = data.getStringExtra("selectedDrink");
                selectedDrinkTextView.setText("Bạn chọn thức uống -> " + selectedDrink);
            }
        }

    }
}

