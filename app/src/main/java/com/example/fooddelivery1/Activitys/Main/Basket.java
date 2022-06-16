package com.example.fooddelivery1.Activitys.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.fooddelivery1.ArrayAdapters.ShoppingCartAdapter;
import com.example.fooddelivery1.Model.Dish;
import com.example.fooddelivery1.Model.RestaurantRegistrator;
import com.example.fooddelivery1.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Basket extends Fragment {


    private ListView shoppingCartListView;
    private List<Dish> shoppingCartList;
    private RestaurantRegistrator restaurantRegistrator;
    private TextView totalAllProducts;
    private TextView totalTax;
    private TextView totaldeliveryprice;
    private TextView totalPrice;
    private double total;
    private double tax;
    private double totalEndPrice;
    private double deliveryprice;
    private ProgressBar progressBar;
    private int numbProgress;
    private static DecimalFormat df2 = new DecimalFormat("#.##");


    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_basket, container, false);

        shoppingCartListView = root.findViewById(R.id.shoppinCartView);
        totalAllProducts = root.findViewById(R.id.totalAllProducts);
        totalTax = root.findViewById(R.id.totalTax);
        totaldeliveryprice = root.findViewById(R.id.deliveryPriceBasket);
        totalPrice = root.findViewById(R.id.totalEndPrice);
        progressBar = root.findViewById(R.id.progressBar);

        restaurantRegistrator = new RestaurantRegistrator();
        shoppingCartList = new RestaurantRegistrator().getBasket();

        List<String> restaurantNames = new ArrayList<>();
        String stringNames=" ";
        for (int i = 0; i < shoppingCartList.size() ; i++) {
            restaurantNames.add(shoppingCartList.get(i).getName());
            stringNames = stringNames+ shoppingCartList.get(i).getName()+"\n";
        }

        final ShoppingCartAdapter adapter = new ShoppingCartAdapter(getContext(), shoppingCartList);
        shoppingCartListView.setAdapter(adapter);

        totalAllProducts.setText(getTotal()+"");
        totalTax.setText(getTax()+"");
        totaldeliveryprice.setText(getDeliveryprice()+"");
        totalPrice.setText(gettotalPrice()+"");
        progressBar.setProgress((int)(totalEndPrice));

        shoppingCartListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String deletename = shoppingCartList.get(position).getName();

                deleteDish(shoppingCartList.get(position));
                Toast.makeText(getActivity(),deletename+" have been deleted",Toast.LENGTH_SHORT).show();
                 adapter.notifyDataSetChanged();
                return false;
            }
        });
        return root;
    }

    public double getTotal(){
        total = 0;
        for (int i = 0; i <shoppingCartList.size() ; i++) {
            total = total + shoppingCartList.get(i).getPrice();
        }
        total = (int) total;

        return Double.valueOf(df2.format(total));

    }

    public double getTax(){
        tax = getTotal() * 0.09;
        return Double.valueOf(df2.format(tax));
    }

    public double getDeliveryprice(){
        if (total == 0){
            deliveryprice = 0.00;
        } else {
            deliveryprice = 2.49;
        }
        return Double.valueOf(df2.format(deliveryprice));
    }

    public void deleteDish(Dish dish){
        shoppingCartList.remove(dish);
    }
    public double gettotalPrice() {
        totalEndPrice = total + deliveryprice +tax;
        return Double.valueOf(df2.format(totalEndPrice));
    }
}