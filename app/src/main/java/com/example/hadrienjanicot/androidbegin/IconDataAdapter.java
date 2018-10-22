package com.example.hadrienjanicot.androidbegin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class IconDataAdapter extends RecyclerView.Adapter<IconDataViewHolder> {

    private ArrayList<Bottle> bottleArrayList;

    public IconDataAdapter(ArrayList<Bottle> icons) { this.bottleArrayList = icons; }

    public IconDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_display, parent, false);
        return new IconDataViewHolder(row);
    }

    public void onBindViewHolder(IconDataViewHolder viewholder, int position) {
        Bottle bottleToDisplay = this.bottleArrayList.get(position);
        viewholder.txvName.setText(bottleToDisplay.getName());
        viewholder.tvxPrice.setText(bottleToDisplay.getPrice()+ " €");
    }

    public int getItemCount() {
        return this.bottleArrayList.size();
    }

}

