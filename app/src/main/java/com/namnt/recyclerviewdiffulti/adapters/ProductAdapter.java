package com.namnt.recyclerviewdiffulti.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.namnt.recyclerviewdiffulti.R;
import com.namnt.recyclerviewdiffulti.holders.ProductViewHolder;
import com.namnt.recyclerviewdiffulti.models.Product;
import com.namnt.recyclerviewdiffulti.utlis.ProductDiffUtilCallBack;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;


public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private ArrayList<Product> mProducts;

    public ProductAdapter(ArrayList<Product> mProducts) {
        this.mProducts = mProducts;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.tvName.setText(mProducts.get(position).name);
        holder.tvPrice.setText(mProducts.get(position).price + "$");
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull List<Object> payloads) {
        String name;
        int price;
        if(payloads.isEmpty()){
            super.onBindViewHolder(holder, position, payloads);
            return;
        }else{
            Bundle bundle = (Bundle) payloads.get(0);
            for(String k : bundle.keySet()){
                if(k.equals("name")){
                    name = bundle.getString(k);
                    holder.tvName.setText(name);
                }
                if(k.equals("price")){
                    price = bundle.getInt(k);
                    holder.tvPrice.setText(price + "$");
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return (mProducts != null) ? mProducts.size() : 0;
    }

    public ArrayList<Product> getData(){
        return mProducts;
    }

    public void setData(ArrayList<Product> products){
        final ProductDiffUtilCallBack productDiffUtilCallBack = new ProductDiffUtilCallBack(products, mProducts);
        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(productDiffUtilCallBack);
        diffResult.dispatchUpdatesTo(this);
        mProducts.clear();
        mProducts.addAll(products);
    }

}
