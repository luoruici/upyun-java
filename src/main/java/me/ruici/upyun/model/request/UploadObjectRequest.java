package me.ruici.upyun.model.request;

import com.google.common.base.Strings;
import me.ruici.upyun.http.Headers;
import me.ruici.upyun.http.HttpMethod;

public class UploadObjectRequest extends UpyunObjectRequest {

    private static final String MKDIR_HEADER = "mkdir";

    private static final String CONTENT_SECRET_HEADER ="Content-Secret";

    public UploadObjectRequest(String bucketName, String key, boolean mkdir, String contentMD5, String contentSecret, String contentType) {
        this.setBucketName(bucketName);
        this.setKey(key);
        if (mkdir) {
            this.addHeader(MKDIR_HEADER, String.valueOf(Boolean.TRUE));
        }
        if (Strings.isNullOrEmpty(contentMD5)) {
            addHeader(Headers.CONTENT_MD5, contentMD5);
        }
        if (Strings.isNullOrEmpty(contentSecret)) {
            this.addHeader(CONTENT_SECRET_HEADER, contentSecret);
        }
        if (Strings.isNullOrEmpty(contentType)) {
            this.addHeader(Headers.CONTENT_TYPE, contentType);
        }
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public String getResourcePath() {
        return String.format("/%s%s", getBucketName(), getKey());
    }
}
