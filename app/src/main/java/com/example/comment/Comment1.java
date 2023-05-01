package com.example.comment;

import java.util.ArrayList;
import java.util.List;

public class Comment1 {
    private String name;
    private String content;
    private List<Comment1> replyList;

    public Comment1(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment1> getReplyList() {
        return replyList;
    }

//    public void setReplyList(List<Comment1> replyList) {
//        this.replyList = replyList;
//    }
    public void addReply(Comment1 reply) {
        if (replyList == null) {
            replyList = new ArrayList<>();
        }
        replyList.add(reply);
    }
}
