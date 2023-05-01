package com.example.comment;

public class News {
    private String content;
    private String time;
    private int imageId;

    public News(String content, String time, int imageId) {
        this.content = content;
        this.time = time;
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
