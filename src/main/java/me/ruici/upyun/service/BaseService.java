package me.ruici.upyun.service;

import me.ruici.upyun.UpyunConfig;

public abstract class BaseService {

    protected final UpyunConfig upyunConfig;

    public BaseService(UpyunConfig upyunConfig) {
        this.upyunConfig = upyunConfig;
    }

}
