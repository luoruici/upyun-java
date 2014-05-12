package me.ruici.upyun.model;

import com.google.common.base.Objects;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class UpyunObject implements Closeable{

    private String key = null;

    private String bucketName = null;

    private ObjectMetadata metadata = new ObjectMetadata();

    private InputStream content;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public ObjectMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ObjectMetadata metadata) {
        this.metadata = metadata;
    }

    public InputStream getContent() {
        return content;
    }

    public void setContent(InputStream content) {
        this.content = content;
    }

    @Override
    public void close() throws IOException {
        if (this.content != null) {
            this.getContent().close();
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("bucketName", this.bucketName)
                .add("key", this.key)
                .toString();
    }
}
