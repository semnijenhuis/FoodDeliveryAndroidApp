package com.example.fooddelivery1.ArrayAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fooddelivery1.Model.Dish;
import com.example.fooddelivery1.R;

import java.util.List;

public class DishAdapter extends ArrayAdapter {

        private ImageView imageView;
        private TextView titel1;
        private TextView titel2;
        private TextView titel3;
        private TextView dishName;
        private TextView dishIngredients;
        private TextView dishPrice;
        private LayoutInflater layoutInflater;
        private List<Dish> dishList;

        public DishAdapter(Context context, List objects) {
            super(context, R.layout.activity_restaurant_menu,objects);
            layoutInflater = LayoutInflater.from(context);
            dishList = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            if (convertView ==null){
                convertView = layoutInflater.inflate(R.layout.activity_menu_items,parent,false);
            }

            titel1 = convertView.findViewById(R.id.itemViewTitel1);
            titel2 = convertView.findViewById(R.id.itemViewTitel2);
            titel3 = convertView.findViewById(R.id.itemViewTitel3);
            titel1.setText("Name");
            titel2.setText("Ingredients");
            titel3.setText("Price");

            //imageView = convertView.findViewById(R.id.restaurantBackground);
            dishName = convertView.findViewById(R.id.itemViewText1);
            dishIngredients = convertView.findViewById(R.id.itemViewText2);
            dishPrice = convertView.findViewById(R.id.itemViewText3);

            Dish dish = dishList.get(position);

            dishName.setText(dish.getName());
            dishIngredients.setText(dish.getIngredient());
            dishPrice.setText("$ "+dish.getPrice());
            return convertView;
        }
}

