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

public class DrinkActivity extends AppCompatActivity {

    private List<String> drinkList;
    private ArrayAdapter<String> drinkAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        ListView drinkListView = findViewById(R.id.drinkListView);
        Button orderButton = findViewById(R.id.orderDrinkButton);

        drinkList = new ArrayList<>();
        drinkList.add("Pepsi");
        drinkList.add("Heineken");
        drinkList.add("Tiger");
        drinkList.add("Bia Sài Gòn Đỏ");

        drinkAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, drinkList);

        drinkListView.setAdapter(drinkAdapter);
        drinkListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // Set choice mode

        drinkListView.setItemChecked(0, true);

        drinkListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedDrink = getSelectedDrink();
                if (!selectedDrink.isEmpty()) {
                    sendResult(selectedDrink);
                } else {

                }
            }
        });
    }

    private String getSelectedDrink() {
        int position = ((ListView) findViewById(R.id.drinkListView)).getCheckedItemPosition();
        if (position != ListView.INVALID_POSITION) {
            return drinkList.get(position);
        } else {
            return "";
        }
    }

    private void sendResult(String selectedDrink) {
        Intent intent = new Intent();
        intent.putExtra("selectedDrink", selectedDrink);
        setResult(RESULT_OK, intent);
        finish();
    }
}
