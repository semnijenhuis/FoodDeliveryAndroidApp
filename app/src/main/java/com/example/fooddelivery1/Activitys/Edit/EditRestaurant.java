package com.example.fooddelivery1.Activitys.Edit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.fooddelivery1.Activitys.Main.Restaurants;
import com.example.fooddelivery1.Activitys.MainActivity;
import com.example.fooddelivery1.Model.Restaurant;
import com.example.fooddelivery1.Model.RestaurantRegistrator;
import com.example.fooddelivery1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class EditRestaurant extends AppCompatActivity {

    private int positionIntheArray;
    private Switch aSwitch;
    private ImageView restaurantImage;
    private EditText nameRestaurant;
    private EditText kitchen;
    private EditText city;
    private List<Restaurant> restaurantList;
    private FloatingActionButton saveButton;
    private FloatingActionButton backButton;
    private RestaurantRegistrator restaurants;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_restaurant);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        positionIntheArray = intent.getIntExtra(Restaurants.RESTAURANT_POSITION_KEY,-1);

        restaurants = new RestaurantRegistrator();
        restaurantList = new RestaurantRegistrator().getRestaurantList();

        restaurantImage = findViewById(R.id.addRestaurantImage);
        nameRestaurant = findViewById(R.id.editNameText);
        kitchen = findViewById(R.id.editKitchenText);
        city = findViewById(R.id.editCityText);
        aSwitch = findViewById(R.id.aSwitchEditRestaurant);

        saveButton = findViewById(R.id.addSaveButton);
        backButton = findViewById(R.id.addRestaurantDiscardButton);

        nameRestaurant.setText(restaurants.getRestaurantList().get(positionIntheArray).getName());
        kitchen.setText(restaurants.getRestaurantList().get(positionIntheArray).getKitchen());
        city.setText(restaurants.getRestaurantList().get(positionIntheArray).getAddress());

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
            Restaurant restaurant = restaurants.getRestaurantList().get(positionIntheArray);

            String textname = nameRestaurant.getText().toString();
            String textkitchen = kitchen.getText().toString();
            String textaddress = city.getText().toString();

            restaurant.setName(textname);
            restaurant.setKitchen(textkitchen);
            restaurant.setAddress(textaddress);


            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
    }

    public void saveData(View view){
        Restaurant restaurant = restaurants.getRestaurantList().get(positionIntheArray);

        String textname = nameRestaurant.getText().toString();
        String textkitchen = kitchen.getText().toString();
        String textaddress = city.getText().toString();

        restaurant.setName(textname);
        restaurant.setKitchen(textkitchen);
        restaurant.setAddress(textaddress);

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        this.finish();
    }

    public void discard(View view){
        restaurants.getRestaurantList().remove(positionIntheArray);

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        this.finish();
    }

}
