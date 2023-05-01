package com.example.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ViewHolder> {
    private List<Reply> mReply;
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        TextView time;
        public ViewHolder(View view) {
            super(view);
            content = (TextView) view.findViewById(R.id.content_ply);
            time = (TextView) view.findViewById(R.id.time_ply);
        }
    }
    public ReplyAdapter(List<Reply> replyList) {
        mReply = replyList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reply_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Reply reply = mReply.get(position);
        holder.content.setText(reply.getContent());
        holder.time.setText(reply.getTime());
    }
    @Override
    public int getItemCount() {
        return mReply.size();
    }
}
