package com.example.hadrienjanicot.androidbegin;

import java.io.Serializable;

public class Bottle implements Serializable {

    String name;
    Float price;

    Bottle(String n, Float p){
        name = n;
        price = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


}
