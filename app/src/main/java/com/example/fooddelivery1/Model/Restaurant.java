package com.example.fooddelivery1.Model;

import java.util.ArrayList;

public class Restaurant {

    private String name;
    private String address;
    private String kitchen;
    private String imageFileName;
    private ArrayList<Dish> dishes;

    public Restaurant(String name, String address, String kitchen) {
        this.name = name;
        this.address = address;
        this.kitchen = kitchen;
        this.imageFileName=name;
        dishes = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getKitchen() { return kitchen; }
    public ArrayList<Dish> getDishes() { return dishes; }
    public String getImageFileName() { return imageFileName; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setKitchen(String kitchen) { this.kitchen = kitchen; }
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public void addDish(Dish dish){ dishes.add(dish); }

    @Override
    public String toString() {
        String line ="";
        line += name +" '"+ kitchen+ " Delivery $"+"\n"+"Dishes:" +"\n";
        for (Dish dish : dishes){ line += dish; }
        return line;
    }
}

