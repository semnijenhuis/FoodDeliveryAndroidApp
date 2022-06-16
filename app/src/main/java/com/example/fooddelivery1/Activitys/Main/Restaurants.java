package com.example.fooddelivery1.Activitys.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.fooddelivery1.Activitys.Add.AddRestaurant;
import com.example.fooddelivery1.Activitys.Edit.EditRestaurant;
import com.example.fooddelivery1.ArrayAdapters.RestaurantAdapter;
import com.example.fooddelivery1.Model.Restaurant;
import com.example.fooddelivery1.Model.RestaurantRegistrator;
import com.example.fooddelivery1.R;
import com.example.fooddelivery1.Activitys.RestaurantMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Restaurants extends Fragment {

    private ListView restaurantListView;
    private List<Restaurant> restaurantList;
    private RestaurantRegistrator restaurantRegistrator;
    private FloatingActionButton button;
    public static final String RESTAURANT_POSITION_KEY="RestaurantPosition";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_restaurants, container, false);
        restaurantListView = (ListView) root.findViewById(R.id.restaurantList);
        button = (FloatingActionButton) root.findViewById(R.id.addrestaurandbutton);

        restaurantRegistrator = new RestaurantRegistrator();
        restaurantList = new RestaurantRegistrator().getRestaurantList();

        List<String> restaurantNames = new ArrayList<>();
        String stringNames=" ";
        for (int i = 0; i < restaurantList.size() ; i++) {
            restaurantNames.add(restaurantList.get(i).getName());
            stringNames = stringNames+restaurantList.get(i).getName()+"\n";
        }

        RestaurantAdapter adapter = new RestaurantAdapter(root.getContext(), restaurantList);
        restaurantListView.setAdapter(adapter);

        restaurantListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), EditRestaurant.class);
                intent.putExtra(RESTAURANT_POSITION_KEY,position);
                startActivity(intent);
            return false;
            }
        });

        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), RestaurantMenu.class);
                intent.putExtra(RESTAURANT_POSITION_KEY,position);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddRestaurant.class);
                startActivity(intent);
            }
        });
        return root;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

}