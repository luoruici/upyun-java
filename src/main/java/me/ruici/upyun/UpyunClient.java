package me.ruici.upyun;

import me.ruici.upyun.auth.BasicUpyunSignCredentials;
import me.ruici.upyun.auth.Credentials;
import me.ruici.upyun.handler.ObjectResponseHandler;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.client.HttpClient;
import me.ruici.upyun.model.GetObjectRequest;
import me.ruici.upyun.model.UpyunObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpyunClient {

    public static final Logger logger = LoggerFactory.getLogger(UpyunClient.class);

    private HttpClient client = new HttpClient();
    private Credentials credentials;
    private String bucketName;

    public UpyunClient(String username, String password, String bucketName) {
        this.credentials = new BasicUpyunSignCredentials(username, password);
        this.bucketName = bucketName;
    }

    public UpyunObject getObject(String key) {
        return getObject(new GetObjectRequest(bucketName, key));
    }

    public UpyunObject getObject(GetObjectRequest getObjectRequest) {
        UpyunHttpRequest request = new UpyunHttpRequest(getObjectRequest);
        logger.debug("getting object {} from {}", getObjectRequest.getKey(), getObjectRequest.getBucketName());
        return client.execute(UpyunConfig.ED_AUTO, request, new ObjectResponseHandler(), this.credentials);
    }
}
