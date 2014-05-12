package me.ruici.upyun.service;

import me.ruici.upyun.UpyunConfig;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.UpyunHttpResponseHandler;
import me.ruici.upyun.http.client.HttpClient;
import me.ruici.upyun.model.MkdirRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MkdirService extends BaseService {

    public static final Logger logger = LoggerFactory.getLogger(MkdirService.class);

    public MkdirService(UpyunConfig upyunConfig) {
        super(upyunConfig);
    }

    public void mkdir(String key) {
        mkdir(key, false);
    }

    public void mkdir(String key, boolean auto) {
        mkdir(new MkdirRequest(this.upyunConfig.getBucketName(), key, auto));
    }

    public void mkdir(MkdirRequest mkdirRequest) {
        UpyunHttpRequest request = new UpyunHttpRequest(mkdirRequest);
        logger.debug("mkdir {} in {}", mkdirRequest.getKey(), mkdirRequest.getBucketName());
        HttpClient.execute(this.upyunConfig.getEndpoint(), request,
                UpyunHttpResponseHandler.VOID_RESPONSE_HANDLER, this.upyunConfig.getCredentials());
    }
}
