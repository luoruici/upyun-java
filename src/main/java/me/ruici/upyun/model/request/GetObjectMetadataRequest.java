package me.ruici.upyun.model.request;

import me.ruici.upyun.http.HttpMethod;

public class GetObjectMetadataRequest extends UpyunObjectRequest {


    public GetObjectMetadataRequest(String bucketName, String key) {
        this.setBucketName(bucketName);
        this.setKey(key);
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.HEAD;
    }

    @Override
    public String getResourcePath() {
        return String.format("/%s%s", getBucketName(), getKey());
    }
}
