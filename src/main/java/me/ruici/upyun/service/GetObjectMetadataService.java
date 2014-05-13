package me.ruici.upyun.service;

import me.ruici.upyun.UpyunConfig;
import me.ruici.upyun.http.handler.ObjectMetadataResponseHandler;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.client.HttpClient;
import me.ruici.upyun.model.request.GetObjectMetadataRequest;
import me.ruici.upyun.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetObjectMetadataService extends BaseService {

    public static final Logger logger = LoggerFactory.getLogger(GetObjectMetadataService.class);

    public GetObjectMetadataService(UpyunConfig upyunConfig) {
        super(upyunConfig);
    }

    public ObjectMetadata getObjectMetadata(String key) {
        return getObjectMetadata(new GetObjectMetadataRequest(this.upyunConfig.getBucketName(), key));
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) {
        UpyunHttpRequest request = new UpyunHttpRequest(getObjectMetadataRequest);

        return HttpClient.execute(this.upyunConfig.getEndpoint(), request,
                new ObjectMetadataResponseHandler(), this.upyunConfig.getCredentials());
    }
}
