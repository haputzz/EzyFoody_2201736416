package com.example.ezyfoodyfinal.Models;

public class MainModel {
    int image;

    public MainModel(int image, String foodName, String foodPrice) {
        this.image = image;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    String foodName;
    String foodPrice;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

}
