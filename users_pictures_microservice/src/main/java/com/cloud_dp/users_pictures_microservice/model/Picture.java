package com.cloud_dp.users_pictures_microservice.model;

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

    public String getUserId() {
        return userId;
    }

    public String getUrl() {
        return url;
    }

}
