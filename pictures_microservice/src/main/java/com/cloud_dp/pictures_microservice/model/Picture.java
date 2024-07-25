package com.cloud_dp.pictures_microservice.model;

public class Picture {
    private String id;
    private String userId;
    private String url;

    public Picture(String id, String userId, String url) {
        this.id = id;
        this.userId = userId;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
