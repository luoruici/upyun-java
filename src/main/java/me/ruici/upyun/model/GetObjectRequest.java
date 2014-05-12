package me.ruici.upyun.model;

import me.ruici.upyun.http.HttpMethod;

public class GetObjectRequest extends UpyunObjectRequest {

    public GetObjectRequest(String bucketName, String key) {
        this.setBucketName(bucketName);
        this.setKey(key);
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getResourcePath() {
        return String.format("/%s/%s", getBucketName(), getKey());
    }
}
