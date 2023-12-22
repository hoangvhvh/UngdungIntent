package org.coolstyles.ungdungintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private List<String> foodList;
    private ArrayAdapter<String> foodAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ListView foodListView = findViewById(R.id.foodListView);
        Button orderButton = findViewById(R.id.orderFoodButton);

        foodList = new ArrayList<>();
        foodList.add("Phở Hà Nội");
        foodList.add("Bún Bò Huế");
        foodList.add("Mì Quảng");
        foodList.add("Hủ Tíu Sài Gòn");

        foodAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, foodList);

        foodListView.setAdapter(foodAdapter);
        foodListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // Set choice mode

        foodListView.setItemChecked(0, true);

        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedFood = getSelectedFood();
                if (!selectedFood.isEmpty()) {
                    sendResult(selectedFood);
                } else {

                }
            }
        });
    }

    private String getSelectedFood() {
        int position = ((ListView) findViewById(R.id.foodListView)).getCheckedItemPosition();
        if (position != ListView.INVALID_POSITION) {
            return foodList.get(position);
        } else {
            return "";
        }
    }

    private void sendResult(String selectedFood) {
        Intent intent = new Intent();
        intent.putExtra("selectedFood", selectedFood);
        setResult(RESULT_OK, intent);
        finish();
    }
}
