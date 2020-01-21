package com.namnt.recyclerviewdiffulti.models;

import androidx.annotation.NonNull;

public class Product implements Comparable, Cloneable{

    public String name;
    public int id, price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        Product compare = (Product)o;
        if(compare.id == this.id && compare.name.equals(this.name) && compare.price == this.price){
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public Product clone(){
        Product clone;
        try{
            clone = (Product) super.clone();
        } catch(CloneNotSupportedException e){
            throw new RuntimeException(e);
        }
        return clone;
    }
}
