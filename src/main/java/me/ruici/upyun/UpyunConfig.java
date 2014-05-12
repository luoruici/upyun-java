package me.ruici.upyun;

import me.ruici.upyun.auth.Credentials;
import me.ruici.upyun.auth.UpyunSignCredentials;

public class UpyunConfig {

    public static final String ED_AUTO = "v0.api.upyun.com";
    public static final String ED_TELECOM = "v1.api.upyun.com";
    public static final String ED_CNC = "v2.api.upyun.com";
    public static final String ED_CTT = "v3.api.upyun.com";

    private final String endpoint;
    private final String bucketName;
    private final Credentials credentials;

    public UpyunConfig(String username, String password, String bucketName) {
        this(username, password, bucketName, ED_AUTO);
    }

    public UpyunConfig(String username, String password, String bucketName, String endpoint) {
        this.credentials = new UpyunSignCredentials(username, password);
        this.bucketName = bucketName;
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
