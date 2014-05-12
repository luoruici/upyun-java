package me.ruici.upyun.http;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import me.ruici.upyun.model.UpyunBaseRequest;

import java.util.Map;

public class UpyunHttpRequest {

    private Map<String, String> headers = Maps.newHashMap();
    private HttpMethod httpMethod;
    private String resourcePath;
    private int contentLength;

    public <X extends UpyunBaseRequest> UpyunHttpRequest(X originalRequest) {
        this(originalRequest.getHttpMethod(), originalRequest.getResourcePath());
        this.headers.putAll(originalRequest.getHeaders());
    }

    private UpyunHttpRequest(HttpMethod httpMethod, String resourcePath) {
        this.httpMethod = httpMethod;
        this.resourcePath = resourcePath;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void addHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("resourcePath", this.resourcePath)
                .add("method", this.httpMethod)
                .toString();
    }
}
