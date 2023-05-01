package com.example.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private List<Comment> mComment;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        TextView time;
        public ViewHolder(View view) {
            super(view);
            content = (TextView) view.findViewById(R.id.content_com);
            time = (TextView) view.findViewById(R.id.time_com);
        }
    }
    public CommentAdapter(List<Comment> commentList) {
        mComment = commentList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comment comment = mComment.get(position);
        holder.content.setText(comment.getContent());
        holder.time.setText(comment.getTime());
    }
    @Override
    public int getItemCount() {
        return mComment.size();
    }
}