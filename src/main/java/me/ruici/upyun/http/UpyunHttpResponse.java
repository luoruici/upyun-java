package me.ruici.upyun.http;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;

import java.io.InputStream;
import java.util.Map;

public class UpyunHttpResponse {

    private String statusText;
    private int statusCode;
    private InputStream content;
    private Map<String, String> headers = Maps.newHashMap();

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("statusCode", this.statusCode)
                .add("message", this.statusText)
                .toString();
    }
}
