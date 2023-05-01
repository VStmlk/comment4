package com.example.comment;

import android.content.DialogInterface;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Comment1Adapter extends RecyclerView.Adapter<Comment1Adapter.ViewHolder> {
    private List<Comment1> comment1List;
    ReplyJump replyJump = new ReplyJump();

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView contentTextView;
        RecyclerView replyRecyclerView;
        TextView replyButton;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            contentTextView = view.findViewById(R.id.contentTextView);
            replyRecyclerView = view.findViewById(R.id.replyRecyclerView);

            //回复的点击事件
            replyButton = view.findViewById(R.id.reply_bu);
            replyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 处理回复按钮的点击事件
                    // 显示回复对话框或启动新的回复界面
                    // 传递评论或回复的ID以标识所回复的评论或回复

                    //将当前的ViewHolder对象作为参数传递给showReplyDialog()方法
                    showReplyDialog(ViewHolder.this,nameTextView.getText().toString());
                }
            });
        }

        private void showReplyDialog(final ViewHolder holder,String name) {

            AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());//holder.itemView.getContext()返回的是 RecyclerView 所在的上下文对象
            builder.setTitle("回复"+name);

            // 创建一个 EditText 控件，用于让用户输入回复内容
            final EditText input = new EditText(holder.itemView.getContext());
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            // 为对话框添加“确定”按钮和“取消”按钮
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String reply = input.getText().toString();
                    // 处理用户输入的回复
                    // 将回复添加到评论中
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            // 显示回复对话框
            AlertDialog dialog = builder.create();
            dialog.show();
        }


    }
    public Comment1Adapter(List<Comment1> comment1List) {
        this.comment1List = comment1List;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comment1 comment1 = comment1List.get(position);//这一段相当于是一直在跟随你鼠标的位置来判断你所选择的数据
        holder.nameTextView.setText(comment1.getName());
        holder.contentTextView.setText(comment1.getContent());

        List<Comment1> replyList = comment1.getReplyList();
        //replyJump.Jump(replyList);
        if (replyList != null && replyList.size() > 0) {
            // 如果有回复，就设置回复列表的布局管理器，并显示出来
            //未设置布局管理器会报如下错误 No layout manager attached; skipping layout
            LinearLayoutManager layoutManager = new LinearLayoutManager(holder.itemView.getContext());
            holder.replyRecyclerView.setLayoutManager(layoutManager);

            Reply1Adapter replyAdapter = new Reply1Adapter(replyList);
            holder.replyRecyclerView.setAdapter(replyAdapter);
            holder.replyRecyclerView.setVisibility(View.VISIBLE);
        } else {
            holder.replyRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return comment1List.size();
    }


}
