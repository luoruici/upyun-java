package me.ruici.upyun.model.request;

import me.ruici.upyun.http.HttpMethod;

public class DeleteObjectRequest extends UpyunObjectRequest {

    public DeleteObjectRequest(String bucketName, String key) {
        this.setBucketName(bucketName);
        this.setKey(key);
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    public String getResourcePath() {
        return String.format("/%s%s", getBucketName(), getKey());
    }
}
