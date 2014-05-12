package me.ruici.upyun.http;

import com.google.common.collect.Maps;

import java.net.URI;
import java.util.Map;

public abstract class HttpRequest {

    private Map<String, String> parameters = Maps.newHashMap();
    private Map<String, String> headers = Maps.newHashMap();
    private HttpMethod httpMethod;
    private URI endpoint;
    private String resourcePath;
    private int contentLength;

    public HttpRequest(HttpMethod method) {
        this.httpMethod = method;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public URI getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(URI endpoint) {
        this.endpoint = endpoint;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public void addHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public void removeHeader(String name) {
        this.headers.remove(name);
    }

    public void addParameter(String name, String value) {
        this.parameters.put(name, value);
    }

    public HttpRequest withParameter(String name, String value) {
        this.addHeader(name, value);

        return this;
    }

    @Override
    public String toString() {
        //TODO: implement toString method
        return super.toString();
    }
}
