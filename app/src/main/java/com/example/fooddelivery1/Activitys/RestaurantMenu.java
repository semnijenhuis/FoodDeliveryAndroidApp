package com.example.fooddelivery1.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fooddelivery1.Activitys.Add.AddMenuItem;
import com.example.fooddelivery1.Activitys.Edit.EditMenuItem;
import com.example.fooddelivery1.Activitys.Main.Restaurants;
import com.example.fooddelivery1.ArrayAdapters.DishAdapter;
import com.example.fooddelivery1.Model.Dish;
import com.example.fooddelivery1.Model.RestaurantRegistrator;
import com.example.fooddelivery1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu extends AppCompatActivity {

    private ListView dishListView;
    private List<Dish> dishList;
    private RestaurantRegistrator registrator;
    private int position;
    private DishAdapter adapter;
    private FloatingActionButton button;
    public static final String MENU_POSITION_KEY="MenuPosition";
    public static final int EDIT_ACTIVITY=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        position = intent.getIntExtra(Restaurants.RESTAURANT_POSITION_KEY,-1);

        registrator = new RestaurantRegistrator();
        dishList = new RestaurantRegistrator().getRestaurantList().get(position).getDishes();

        dishListView = findViewById(R.id.dishList);
        button = findViewById(R.id.restaurantMenuAddItemButton);
        registerForContextMenu(dishListView);


        List<String> dishNames = new ArrayList<>();
        String stringNames=" ";
        for (int i = 0; i < dishList.size() ; i++) {
            dishNames.add(dishList.get(i).getName());
            stringNames = stringNames+ dishList.get(i).getName()+"\n";
        }

        adapter = new DishAdapter(this, dishList);
        dishListView.setAdapter(adapter);

        dishListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dish dish = dishList.get(position);
                String nameadd = dishList.get(position).getName();
                registrator.addToBasket(dish);
                Toast.makeText(RestaurantMenu.this,nameadd+ " have been added",Toast.LENGTH_SHORT).show();
            }
        });

        dishListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                whenLongItemClicked(position);
                return false;
            }
        });



    }

    private final void whenLongItemClicked(int position) {
        Intent intent =new Intent(this, EditMenuItem.class);
        intent.putExtra(MENU_POSITION_KEY,position);
        startActivityForResult(intent,EDIT_ACTIVITY);
    }

    public void addMenuItemButton(View view){
        Intent intent = new Intent(this, AddMenuItem.class);
        intent.putExtra(MENU_POSITION_KEY,position);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
