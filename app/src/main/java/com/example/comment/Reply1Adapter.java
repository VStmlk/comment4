package com.example.comment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Reply1Adapter extends RecyclerView.Adapter<Reply1Adapter.ViewHolder> {

    private List<Comment1> reply1List;

    public Reply1Adapter(List<Comment1> reply1List) {
        this.reply1List = reply1List;
        Log.d("Reply1Adapter","11111111111111111111111111");
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reply, parent, false);
        Log.d("onCreateViewHolder","2222222111111111111");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comment1 reply = reply1List.get(position);
        holder.nameTextView.setText(reply.getName());
        holder.contentTextView.setText(reply.getContent());
        Log.d("onBindViewHolder","3333333333333332111111111111");
    }

    @Override
    public int getItemCount() {
        Log.d("getItemCount","4444444444441111111");
        return reply1List.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView contentTextView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
            Log.d("ViewHolder","5555555555555511111111");
        }
    }
}
