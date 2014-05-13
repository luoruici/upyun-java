package me.ruici.upyun.service;

import me.ruici.upyun.UpyunConfig;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.UpyunHttpResponseHandler;
import me.ruici.upyun.http.client.HttpClient;
import me.ruici.upyun.model.request.DeleteObjectRequest;

public class DeleteObjectService extends BaseService {

    public DeleteObjectService(UpyunConfig upyunConfig) {
        super(upyunConfig);
    }

    public void deleteObject(String key) {
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(this.upyunConfig.getBucketName(), key);

        HttpClient.execute(this.upyunConfig.getEndpoint(), new UpyunHttpRequest(deleteObjectRequest),
                UpyunHttpResponseHandler.VOID_RESPONSE_HANDLER, this.upyunConfig.getCredentials());
    }
}
