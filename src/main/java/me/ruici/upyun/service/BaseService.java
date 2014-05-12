package me.ruici.upyun.service;

import me.ruici.upyun.UpyunConfig;
import me.ruici.upyun.http.client.HttpClient;

public abstract class BaseService {

    protected final UpyunConfig upyunConfig;
    protected HttpClient client;

    public BaseService(UpyunConfig upyunConfig) {
        this.upyunConfig = upyunConfig;
        this.client = new HttpClient();
    }

}
