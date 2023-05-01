package com.example.comment;

public class Reply1 {
    private String userName;
    private String content;

    public Reply1(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }
}