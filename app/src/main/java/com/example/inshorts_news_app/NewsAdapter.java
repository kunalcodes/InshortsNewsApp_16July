package com.example.inshorts_news_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<DataModel> dataItemsList;

    public NewsAdapter(List<DataModel> dataItemsList) {
        this.dataItemsList = dataItemsList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        DataModel dataModel = dataItemsList.get(position);
        holder.setData(dataModel);

    }

    @Override
    public int getItemCount() {
        return dataItemsList.size();
    }
    public void updateData(List<DataModel> dataItemsList){
        this.dataItemsList = dataItemsList;
        notifyDataSetChanged();
    }
}