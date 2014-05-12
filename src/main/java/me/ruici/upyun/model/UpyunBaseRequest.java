package me.ruici.upyun.model;

import me.ruici.upyun.http.HttpMethod;

public abstract class UpyunBaseRequest {

    private String bucketName;

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public abstract HttpMethod getHttpMethod();

    public abstract String getResourcePath();
}
