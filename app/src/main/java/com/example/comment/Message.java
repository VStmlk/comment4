package com.example.comment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Message extends AppCompatActivity {
    private boolean isCollected = false;  // 当前收藏状态
    private List<Comment1> comment1List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_comment);

        TextView time = (TextView) findViewById(R.id.message_time);
        TextView content = (TextView) findViewById(R.id.message_content);


        Intent intent = getIntent();
        String mstime = intent.getStringExtra("time");
        String mstent = intent.getStringExtra("content");
        time.setText(mstime);
        content.setText(mstent);

        intiCom();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.commentRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Comment1Adapter adapter = new Comment1Adapter(comment1List);
        recyclerView.setAdapter(adapter);


        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id==R.id.menu_comment){
                showCommentDialog();
            }
//            switch (item.getItemId()) {
//                case R.id.menu_comment://若报Constant expression required错，将switch语句转换为if-else语句
//                    showCommentDialog();
//                    return true;
//                default:
//                    return false;
//            }
            if (id==R.id.menu_collect){
                if (isCollected){
                    // 取消收藏
                    isCollected = false;
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                } else {
                    // 收藏
                    isCollected = true;
                    //Toast.makeText(getApplicationContext(), "已收藏", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "已收藏", Toast.LENGTH_SHORT).show();
                }

            }
            return false;
        });


    }

    private void showCommentDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.comment);

        // 创建一个 EditText 控件，用于让用户输入评论内容
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // 为对话框添加“确定”按钮和“取消”按钮
        builder.setPositiveButton(R.string.ok, (dialog, which) -> {
            String comment = input.getText().toString();
            // 处理用户输入的评论
            Log.d("处理用户输入的评论",comment);
        });
        builder.setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

        // 显示评论对话框
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    private void intiCom(){
        //在 intiCom() 方法中，您声明了一个新的 comment1List，并将值添加到其中，但这个列表只在方法内部可见，而不是在整个 Message 类中可见。
        //List<Comment1> comment1List = new ArrayList<>();
        Comment1 comment01 = new Comment1("John", "This is the first comment.");
        Comment1 reply1 = new Comment1("Tom", "Thanks for your comment.");
        Comment1 reply2 = new Comment1("Jerry", "I agree with you.");
        comment01.addReply(reply1);
        comment01.addReply(reply2);
        Comment1 comment02 = new Comment1("Mary", "This is the second comment.");
        Comment1 comment03 = new Comment1("Jack", "This is the three comment.");
        comment1List.add(comment01);
        comment1List.add(comment02);
        comment1List.add(comment03);
//        for(Comment1 item:comment01.getReplyList()){
//            System.out.println(item.getName()+"===================================");
//        }

    }
}