package com.example.fooddelivery1.ArrayAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.fooddelivery1.Model.Dish;
import com.example.fooddelivery1.R;
import java.util.List;

public class ShoppingCartAdapter extends ArrayAdapter {

    private TextView dishName;
    private TextView dishPrice;
    private LayoutInflater layoutInflater;
    private List<Dish> dishList;

    public ShoppingCartAdapter(Context context, List objects) {
        super(context, R.layout.fragment_basket,objects);
        layoutInflater = LayoutInflater.from(context);
        dishList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView ==null){
            convertView = layoutInflater.inflate(R.layout.activity_shopping_cart_items,parent,false);
        }
        dishName = convertView.findViewById(R.id.productName);
        dishPrice = convertView.findViewById(R.id.productPrice);

        Dish dish = dishList.get(position);

        dishName.setText(dish.getName());
        dishPrice.setText(dish.getPrice()+"");

        return convertView;
    }
}
