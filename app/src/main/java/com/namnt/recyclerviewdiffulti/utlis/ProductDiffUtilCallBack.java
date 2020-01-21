package com.namnt.recyclerviewdiffulti.utlis;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.namnt.recyclerviewdiffulti.models.Product;

import java.util.ArrayList;

public class ProductDiffUtilCallBack extends DiffUtil.Callback {

    ArrayList<Product> newList;
    ArrayList<Product> oldList;

    public ProductDiffUtilCallBack(ArrayList<Product> newList, ArrayList<Product> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return (oldList != null) ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return (newList != null) ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newList.get(newItemPosition).id == oldList.get(oldItemPosition).id;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        return result == 0;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Product newProduct = newList.get(newItemPosition);
        Product oldProduct = oldList.get(oldItemPosition);
        Bundle diff = new Bundle();
        if(newProduct.price != oldProduct.price){
            diff.putInt("price", newProduct.price);
        }
        if(!newProduct.name.equals(oldProduct.name)){
            diff.putString("name", newProduct.name);
        }
        if(diff.size() == 0){
            return null;
        }
        return diff;
    }
}
