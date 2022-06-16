package com.example.fooddelivery1.Activitys.Add;

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
import com.example.fooddelivery1.Model.Restaurant;
import com.example.fooddelivery1.Model.RestaurantRegistrator;
import com.example.fooddelivery1.R;

public class AddMenuItem extends AppCompatActivity {

    private int position;
    private EditText dishName;
    private EditText dishIngredients;
    private EditText dishPrice;
    private RestaurantRegistrator registrator;
    private Restaurant restaurant;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu_item);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        position = intent.getIntExtra(RestaurantMenu.MENU_POSITION_KEY,-1);

        registrator = new RestaurantRegistrator();
        restaurant = registrator.getRestaurantList().get(position);

        dishName = findViewById(R.id.addMenuItemNameText);
        dishIngredients = findViewById(R.id.addMenuItemIngredientsText);
        dishPrice = findViewById(R.id.addMenuItemPriceText);
        aSwitch = findViewById(R.id.aSwitchAddMenu);


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    Toast.makeText(getBaseContext(),"Data will be saved",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(),"Data wont be saved",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (aSwitch.isChecked()){
            String textname = dishName.getText().toString();
            String textkitchen = dishIngredients.getText().toString();
            Double textaddress = Double.valueOf(dishPrice.getText().toString());

            Dish dish = new Dish(textname,textkitchen,textaddress);
            restaurant.addDish(dish);

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
    }

    public void addMenuSave(View view){
        String textname = dishName.getText().toString();
        String textkitchen = dishIngredients.getText().toString();
        Double textaddress = Double.valueOf(dishPrice.getText().toString());

        Dish dish = new Dish(textname,textkitchen,textaddress);
        restaurant.addDish(dish);

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        this.finish();
    }

    public void addMenuDiscard(View view) {
        if (aSwitch.isChecked()){
            String textname = dishName.getText().toString();
            String textkitchen = dishIngredients.getText().toString();
            Double textaddress = Double.valueOf(dishPrice.getText().toString());

            Dish dish = new Dish(textname,textkitchen,textaddress);
            restaurant.addDish(dish);

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        } else  {
            this.finish();
        }
    }
}
