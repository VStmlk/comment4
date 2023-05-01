package com.example.comment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private static List<News> mNews;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        TextView time;
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            content = (TextView) view.findViewById(R.id.news_title);
            time = (TextView) view.findViewById(R.id.news_time);
            image = (ImageView) view.findViewById(R.id.news_image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); // 获取被点击的列表项位置
                    News news = mNews.get(position);// 获取被点击的列表项数据

                    // 创建一个Intent并设置目标Activity
                    Intent intent = new Intent(v.getContext(), Message.class);
                    intent.putExtra("time", news.getTime());
                    intent.putExtra("content", news.getContent());

                    // 启动新的Activity
                    v.getContext().startActivity(intent);
                }
            });
        }

    }
    public NewsAdapter(List<News> newsList) {
        mNews = newsList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News news = mNews.get(position);
        holder.content.setText(news.getContent());
        holder.time.setText(news.getTime());
        holder.image.setImageResource(news.getImageId());

    }
    @Override
    public int getItemCount() {
        return mNews.size();
    }
}