package com.example.fooddelivery1.Activitys.Edit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.fooddelivery1.Activitys.MainActivity;
import com.example.fooddelivery1.Activitys.RestaurantMenu;
import com.example.fooddelivery1.Model.Dish;

import com.example.fooddelivery1.Model.RestaurantRegistrator;
import com.example.fooddelivery1.R;

import java.util.List;

public class EditMenuItem extends AppCompatActivity {

    private int positionMenu;
    private EditText dishName;
    private EditText dishIngredients;
    private EditText dishPrice;
    private Switch aSwitch;
    private List<Dish> dishList;
    private Dish dish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu_item);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        positionMenu = intent.getIntExtra(RestaurantMenu.MENU_POSITION_KEY, -1);

        dishName = findViewById(R.id.editMenuItemName);
        dishIngredients = findViewById(R.id.editMenuItemIngredients);
        dishPrice = findViewById(R.id.editMenuItemPrice);
        aSwitch = findViewById(R.id.aSwitchEditMenu);

        dishList = new RestaurantRegistrator().getRestaurantList().get(0).getDishes();

        dish = dishList.get(positionMenu);

        dishName.setText(dish.getName());
        dishIngredients.setText(dish.getIngredient());
        dishPrice.setText(Double.toString(dish.getPrice()));

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Toast.makeText(getBaseContext(), "Data will be saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Data wont be saved", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (aSwitch.isChecked()) {
            String textname = dishName.getText().toString();
            String textingredients = dishIngredients.getText().toString();
            String textprice = dishPrice.getText().toString();

            dish.setName(textname);
            dish.setIngredient(textingredients);
            dish.setPrice(Double.valueOf(textprice));

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
    }

    public void saveEditMenuItem (View view){
            String textname = dishName.getText().toString();
            String textingredients = dishIngredients.getText().toString();
            String textprice = dishPrice.getText().toString();

            dish.setName(textname);
            dish.setIngredient(textingredients);
            dish.setPrice(Double.valueOf(textprice));

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        this.finish();
        }

        public void discardEditMenuItem (View view){
           dishList.remove(dish);

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
    }
}
