package com.example.fooddelivery1.Model;

public class Dish {

    private String name;
    private String ingredient;
    private double price;

    public Dish(String name, String ingredient, double price) {
        this.name = name;
        this.ingredient = ingredient;
        this.price = price;
    }

    public String getName() { return name; }
    public String getIngredient() { return ingredient; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setIngredient(String ingredient) { this.ingredient = ingredient; }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "'"+name + "' for $" + price+ " made of '" + ingredient+ "'"
                +"\n";
    }

}
