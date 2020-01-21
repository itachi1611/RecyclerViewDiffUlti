package com.namnt.recyclerviewdiffulti.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.namnt.recyclerviewdiffulti.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvName)
    public TextView tvName;
    @BindView(R.id.tvPrice)
    public TextView tvPrice;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
