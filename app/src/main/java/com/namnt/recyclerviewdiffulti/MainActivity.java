package com.namnt.recyclerviewdiffulti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.namnt.recyclerviewdiffulti.adapters.ProductAdapter;
import com.namnt.recyclerviewdiffulti.models.Product;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    private ProductAdapter adapter;

    private ArrayList<Product> list = new ArrayList<>();

    public int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initRecyclerView();
    }

    @OnClick(R.id.fabAddList)
    protected void addMoreItem(){
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : list){
            products.add(product.clone());
        }
        products.add(new Product(i++, "Tron", 1));
        products.add(new Product(i++, "Ripple", 5));
        products.add(new Product(i++, "NEO", 100));
        products.add(new Product(i++, "OMG", 20));

        adapter.setData(products);
    }

    @OnClick(R.id.fabChangeList)
    protected void changePrice(){
        ArrayList<Product> products = new ArrayList<>();
        for(Product product : list){
            products.add(product.clone());
        }

        for(Product product : products){
            if(product.price < 900){
                product.price = 900;
            }
        }
        adapter.setData(products);
    }

    private void initData() {
        list.add(new Product(i++, "Bitcoin", 8000));
        list.add(new Product(i++, "Ethereum", 600));
        list.add(new Product(i++, "Litecoin", 250));
        list.add(new Product(i++, "Bitcoin Cash", 1000));
    }

    private void initRecyclerView(){
        adapter = new ProductAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

}
