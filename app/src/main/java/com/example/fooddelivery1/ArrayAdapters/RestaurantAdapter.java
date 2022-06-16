package com.example.fooddelivery1.ArrayAdapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fooddelivery1.Model.Restaurant;
import com.example.fooddelivery1.R;

import java.io.File;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter {

    private ImageView imageView;
    private TextView name;
    private TextView kitchen;
    private TextView address;
    private TextView titel1;
    private TextView titel2;
    private TextView titel3;
    private LayoutInflater layoutInflater;
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(Context context, List objects) {
        super(context, R.layout.fragment_restaurants_item,objects);
        layoutInflater = LayoutInflater.from(context);
        restaurantList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView ==null){
            convertView = layoutInflater.inflate(R.layout.fragment_restaurants_item,parent,false);
        }
        titel1 = convertView.findViewById(R.id.itemViewTitel1);
        titel2 = convertView.findViewById(R.id.itemViewTitel2);
        titel3 = convertView.findViewById(R.id.itemViewTitel3);

        imageView = convertView.findViewById(R.id.itemViewImage);
        name = convertView.findViewById(R.id.itemViewText1);
        kitchen = convertView.findViewById(R.id.itemViewText2);
        address = convertView.findViewById(R.id.itemViewText3);

        Restaurant restaurant = restaurantList.get(position);

        titel1.setText("Name");
        titel2.setText("Kitchen");
        titel3.setText("Address");
        name.setText(restaurant.getName());
        kitchen.setText(restaurant.getKitchen());
        address.setText(restaurant.getAddress());

        String imageFile = restaurant.getImageFileName();
        imageView.setImageURI(Uri.fromFile(new File(restaurant.getImageFileName())));
        return convertView;
    }
}
