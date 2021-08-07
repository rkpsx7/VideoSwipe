package com.example.videoswipe;

public class Model {
    String url;
    String title, detail;

    public Model(String  url, String title, String detail) {
        this.url = url;
        this.title = title;
        this.detail = detail;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }


}
