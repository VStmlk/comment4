package com.example.comment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import com.example.comment.ReplyMain;

public class MainActivity extends AppCompatActivity {


    private List<News> newsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiCom();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comment_re);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

//        Intent intent = new Intent(this,Message.class);
//        String con = "234-324-23-4-234";
//        String tent = "司法考试萨克管盛大的能否";
//        intent.putExtra("time",con);
//        intent.putExtra("content",tent);
//        startActivity(intent);

    }

    private void intiCom(){
        for (int i =0;i < 2;i++){
            News new1 = new News("1111接下来需要为RecyclerView准备一个适配器，新建FruitAdapter类，让这个适配器继承自RecyclerView.Adapter，并将泛型指定为FruitAdapter.ViewHolder。其中，ViewHolder是我们在FruitAdapter中定义的一个内部类，代码如下所示："
                    ,"11111 0：20",R.drawable.image_head);
            newsList.add(new1);
            News new2 = new News("222222123123123一个适123配器，新建FruitAdapter类，让这个适配器继承自RecyclerView.Adapter，并将泛型指定为FruitAdapter.ViewHolder。其中，ViewHolder是我们在FruitAdapter中定义的一个内部类，代码如下所示："
                    ,"22222",R.drawable.image_head);
            newsList.add(new2);
            News new3 = new News("3333333123一由于SecondActivity不是主活动，因此不需要配置<intent-filter>标签里的内容，注册活动的代码也简单了许多。现在第二个活动已经创建完成，剩下的问题就是如何去启动这第二个活动了，这里我们需要引入一个新的概念：Intent。Intent是Android程序中各组件之间进行交互的一种重要方式，它不仅可以指明当前组件想要执行的动作，还可以在不同组件之间传递数据。Intent一般可被用于启动活动、启动服务以及发送广播等场景，由于服务、广播等概念你暂时还未涉及，那么本章我们的目光无疑就锁定在了启动活动上面。Intent大致可以分为两种：显式Intent和隐式Intent，我们先来看一下显式Intent如何使用。Intent有多个构造函数的重载，其中一个是Intent(Context packageContext, Class<? >cls)。这个构造函数接收两个参数，第一个参数Context要求提供一个启动活动的上下文，第二个参数Class则是指定想要启动的目标活动，通过这个构造函数就可以构建出Intent的“意图”。然后我们应该怎么使用这个Intent呢？Activity类中提供了一个s个适123配器，新建FruitAdapter类，让这个适配器继承自RecyclerView.Adapter，并将泛型指定为FruitAdapter.ViewHolder。其中，ViewHolder是我们在FruitAdapter中定义的一个内部类，代码如下所示："
                    ,"333333330",R.drawable.image_head);
            newsList.add(new3);
        }
    }

//    private List<Comment> commentList = new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        intiCom();
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comment_re);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        CommentAdapter adapter = new CommentAdapter(commentList);
//        recyclerView.setAdapter(adapter);
//
//        ReplyMain replyMain =new ReplyMain();
//        startActivity(replyMain);
//
//    }
//
//    private void intiCom(){
//        for (int i =0;i < 2;i++){
//            Comment com1 = new Comment("接下来需要为RecyclerView准备一个适配器，新建FruitAdapter类，让这个适配器继承自RecyclerView.Adapter，并将泛型指定为FruitAdapter.ViewHolder。其中，ViewHolder是我们在FruitAdapter中定义的一个内部类，代码如下所示："
//            ,"23-4-30 0：20");
//            commentList.add(com1);
//            Comment com2 = new Comment("接下来需要为RecyclerView准备一个适配器，新建FruitAdapter类，让这个适配器继承自RecyclerView.Adapter，并将泛型指定为FruitAdapter.ViewHolder。其中，ViewHolder是我们在FruitAdapter中定义的一个内部类，代码如下所示："
//                    ,"23-4-30 0：20");
//            commentList.add(com2);
//        }
//    }
}