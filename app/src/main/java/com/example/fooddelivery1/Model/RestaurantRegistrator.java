package com.example.fooddelivery1.Model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRegistrator {

    private String imageFileName;
    public static ArrayList<Restaurant> restaurantsList = new ArrayList<>();
    private static ArrayList<Dish> basket = new ArrayList<>();
    private static int begin;

    public RestaurantRegistrator(){

        if (begin<1){
            Restaurant Subway = new Restaurant("Subway","Doetinchemweg 3","Lunch");
            Restaurant KFC = new Restaurant("KFC","Arnhemseweg 6","Chicken");
            Restaurant BurgerKing = new Restaurant("BurgerKing","Zwolleseweg 30","Burgers");

            restaurantsList.add(Subway);
            restaurantsList.add(KFC);
            restaurantsList.add(BurgerKing);

            Dish fries = new Dish("Fries","Patatos",3.99);
            Dish hamburger = new Dish("Hamburger","Cow meat",6.75);
            Dish cookie = new Dish("Cookie","Dough & chocalade",1.95);

            Subway.addDish(fries);
            Subway.addDish(hamburger);
            Subway.addDish(cookie);

            KFC.addDish(fries);
            KFC.addDish(hamburger);
            KFC.addDish(cookie);

            BurgerKing.addDish(fries);
            BurgerKing.addDish(hamburger);
            BurgerKing.addDish(cookie);

            begin =2;
        }

    }

    public List<Restaurant> getRestaurantList(){ return restaurantsList; }
    public  ArrayList<Dish> getBasket() { return basket; }

    public void addToBasket(Dish dish){ basket.add(dish); }
    public void addRestaurant(String name, String address, String kitchen){
        Restaurant restaurant = new Restaurant(name,address,kitchen);
        restaurantsList.add(restaurant);
    }
    @Override
    public String toString() {

        String line ="";
        line += "FoodDelivery " + " \n"+
                " \n"+
                "Restaurants:" + "\n" +
                " \n";

        for (Restaurant restaurant : restaurantsList){
            line += restaurant+"\n";
        }
        return line;
    }
}
