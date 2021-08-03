package com.example.inshorts_news_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class NewsViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView title;
    private TextView content;
    private TextView author;
    private TextView date;
    private TextView time;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        imageView = itemView.findViewById(R.id.imageNews);
        title = itemView.findViewById(R.id.titleNews);
        content = itemView.findViewById(R.id.contentNews);
        author = itemView.findViewById(R.id.author);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);

    }

    public void setData(DataModel dataModel) {
        Glide.with(imageView).load(dataModel.getImageUrl()).into(imageView);
        title.setText(dataModel.getTitle());
        content.setText(dataModel.getContent());
        author.setText(dataModel.getAuthor());
        date.setText(dataModel.getDate());
        time.setText(dataModel.getTime());
    }
}