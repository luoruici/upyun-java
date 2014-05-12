package me.ruici.upyun.model;

import com.google.common.collect.Maps;
import me.ruici.upyun.http.HttpMethod;

import java.util.Map;

public abstract class UpyunBaseRequest {

    private String bucketName;
    private Map<String, String> headers = Maps.newHashMap();

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public abstract HttpMethod getHttpMethod();

    public abstract String getResourcePath();

    public void addHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
