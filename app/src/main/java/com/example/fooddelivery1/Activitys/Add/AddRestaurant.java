package com.example.fooddelivery1.Activitys.Add;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.fooddelivery1.Activitys.MainActivity;
import com.example.fooddelivery1.Activitys.RestaurantMenu;
import com.example.fooddelivery1.Model.Restaurant;
import com.example.fooddelivery1.Model.RestaurantRegistrator;
import com.example.fooddelivery1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddRestaurant extends AppCompatActivity {

    private ImageView restaurantImage;
    private EditText nameRestaurant;
    private EditText kitchen;
    private EditText city;
    private int position;
    private Switch aSwitch;
    private RestaurantRegistrator restaurants;
    private static final int IMAGE_CAPTURE_REQUEST=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);
        getSupportActionBar().hide();

        restaurants = new RestaurantRegistrator();

        Intent intent = getIntent();
        position = intent.getIntExtra(RestaurantMenu.MENU_POSITION_KEY,-1);

        restaurantImage = findViewById(R.id.addRestaurantImage);
        nameRestaurant = findViewById(R.id.addRestaurantNameText);
        kitchen = findViewById(R.id.addRestaurantKitchenText);
        city = findViewById(R.id.addRestaurantAddressText);
        aSwitch = findViewById(R.id.aSwitchAddRestaurant);

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
            String textname = nameRestaurant.getText().toString();
            String textkitchen = kitchen.getText().toString();
            String textaddress = city.getText().toString();

            restaurants.addRestaurant(textname,textaddress,textkitchen);

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
    }

    public void addImage(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,IMAGE_CAPTURE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==IMAGE_CAPTURE_REQUEST && resultCode== Activity.RESULT_OK){
            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
            restaurantImage.setImageBitmap(bitmap);
            String filePath=saveToInternalStorage(bitmap);
        }
    }

    public String saveToInternalStorage(Bitmap bitmap){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        Context context=getApplicationContext();
        File directory = context.getCacheDir();//cw.getDir("imageDir", Context.MODE_PRIVATE);
        File mypath=new File(directory,nameRestaurant.getText().toString()+".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();

    }

    public void addRestaurantSave(View view) {
        String textname = nameRestaurant.getText().toString();
        String textkitchen = kitchen.getText().toString();
        String textaddress = city.getText().toString();

        restaurants.addRestaurant(textname,textaddress,textkitchen);
//        restaurant.setImageFileName(textname);

        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        this.finish();
    }

    public void addRestaurantDisard(View view) {
        if (aSwitch.isChecked()){
            String textname = nameRestaurant.getText().toString();
            String textkitchen = kitchen.getText().toString();
            String textaddress = city.getText().toString();

            restaurants.addRestaurant(textname,textaddress,textkitchen);

            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
        else {

            this.finish();
        }
    }

}
