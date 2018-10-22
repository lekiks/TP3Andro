package com.example.hadrienjanicot.androidbegin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class IconDataViewHolder extends RecyclerView.ViewHolder {

    public TextView txvName;
    public TextView tvxPrice;

    public IconDataViewHolder(View rootView) {
        super(rootView);
        this.txvName = rootView.findViewById(R.id.name);
        this.tvxPrice = rootView.findViewById(R.id.price);
    }

}

