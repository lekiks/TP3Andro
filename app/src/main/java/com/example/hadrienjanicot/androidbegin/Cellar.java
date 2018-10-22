package com.example.hadrienjanicot.androidbegin;

import java.util.ArrayList;

public class Cellar {

    public ArrayList<Bottle> bottleList = new ArrayList<>();
    static float CONVERSION_DOLLAR = 0.85f;

    void addBottle(String name, Float price){
        bottleList.add(new Bottle(name,price));
    }

    void addBottle(Bottle b){
        bottleList.add(b);
    }

    Bottle getBottle(String name){
        for(Bottle b: bottleList){
            if (b.name == name){
                return b;
            }
        }
        return null;
    }

    float getTotalPriceInEuros(){
        float sum = 0;
        for(Bottle b: bottleList){
            sum = sum + b.price;
        }
        return sum;
    }

    float getTotalPriceInDollars(){
        return CONVERSION_DOLLAR * getTotalPriceInEuros();
    }

    int getNumberOfBottles(){
        return bottleList.size();
    }

    String cellarView(){
        String output = "";
        for(Bottle b: bottleList){
            output += b.getName() + ": " + b.getPrice() + "\n";
        }
        return output;
    }
}
