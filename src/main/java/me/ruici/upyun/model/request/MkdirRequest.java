package me.ruici.upyun.model.request;

import me.ruici.upyun.http.HttpMethod;

public class MkdirRequest extends UpyunObjectRequest {

    private static final String FOLDER_HEADER_NAME = "Folder";
    private static final String AUTO_MKDIR_HEADER_NAME = "mkdir";

    public MkdirRequest(String bucketName, String key) {
        this(bucketName, key, false);
    }

    public MkdirRequest(String bucketName, String key, boolean auto) {
        this.setBucketName(bucketName);
        this.setKey(key);
        this.addHeader(FOLDER_HEADER_NAME, String.valueOf(Boolean.TRUE));
        if (auto) {
            this.addHeader(AUTO_MKDIR_HEADER_NAME, String.valueOf(Boolean.TRUE));
        }
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getResourcePath() {
        return String.format("/%s%s", getBucketName(), getKey());
    }
}
