package com.example.comment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReplyMain extends AppCompatActivity {

    private List<Reply> replyList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_item);
        intiPly();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.reply_re);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ReplyAdapter adapter = new ReplyAdapter(replyList);
        recyclerView.setAdapter(adapter);
    }

    private void intiPly(){
        for (int i =0;i < 2;i++){
            Reply ply1 = new Reply("回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1回复1"
                    ,"111111");
            replyList.add(ply1);
            Reply ply2 = new Reply("回复2回复2回复2回复2回复2回复2回复2回复2回复2回复2回复2回复2回复2回复2"
                    ,"111111");
            replyList.add(ply2);
        }
    }
}
