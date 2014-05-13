package me.ruici.upyun.service;

import me.ruici.upyun.UpyunConfig;
import me.ruici.upyun.http.handler.ObjectResponseHandler;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.client.HttpClient;
import me.ruici.upyun.model.request.GetObjectRequest;
import me.ruici.upyun.model.UpyunObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetObjectService extends BaseService {

    public static final Logger logger = LoggerFactory.getLogger(GetObjectService.class);

    public GetObjectService(UpyunConfig upyunConfig) {
        super(upyunConfig);
    }

    public UpyunObject getObject(String key) {
        return getObject(new GetObjectRequest(this.upyunConfig.getBucketName(), key));
    }

    public UpyunObject getObject(GetObjectRequest getObjectRequest) {
        UpyunHttpRequest request = new UpyunHttpRequest(getObjectRequest);
        logger.debug("getting object {} from {}", getObjectRequest.getKey(), getObjectRequest.getBucketName());
        return HttpClient.execute(this.upyunConfig.getEndpoint(), request,
                new ObjectResponseHandler(), this.upyunConfig.getCredentials());
    }
}
