package com.cloud_dp.users_pictures_microservice.entities;

public class Picture {
    private String id;
    private String userId;
    private String url;

    public Picture() {
    }

    public Picture(String id, String userId, String url) {
        this.id = id;
        this.userId = userId;
        this.url = url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUrl() {
        return url;
    }

}
