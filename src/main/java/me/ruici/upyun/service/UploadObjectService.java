package me.ruici.upyun.service;

import me.ruici.upyun.UpyunConfig;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.UpyunHttpResponseHandler;
import me.ruici.upyun.http.client.HttpClient;
import me.ruici.upyun.model.request.UploadObjectRequest;

public class UploadObjectService extends BaseService {

    public UploadObjectService(UpyunConfig upyunConfig) {
        super(upyunConfig);
    }

    public void uploadObject(String key, byte[] data) {
        uploadObject(key, false, null, null, null, data);
    }

    /**
     * Upload Object to Upyun
     * @param key Object Key, not null
     * @param auto auto mkdir, default false
     * @param contentMD5 if set, server will check the upload content via this MD5 value
     * @param contentSecret if set, server will protected origin file from accessing external without whis secret
     * @param contentType if set, using this as file type otherwise auto dectect
     * @param data content of object
     */
    public void uploadObject(String key, boolean auto, String contentMD5,
                             String contentSecret, String contentType, byte[] data) {
        UploadObjectRequest uploadObjectRequest =
                new UploadObjectRequest(this.upyunConfig.getBucketName(), key, auto, contentMD5, contentSecret, contentType);
        uploadObject(uploadObjectRequest, data);
    }
    public void uploadObject(UploadObjectRequest uploadObjectRequest, byte[] data) {
        UpyunHttpRequest request = new UpyunHttpRequest(uploadObjectRequest, data);

        HttpClient.execute(this.upyunConfig.getEndpoint(), request,
                UpyunHttpResponseHandler.VOID_RESPONSE_HANDLER, this.upyunConfig.getCredentials());
    }
}
