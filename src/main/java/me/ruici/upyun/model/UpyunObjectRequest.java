package me.ruici.upyun.model;

public abstract class UpyunObjectRequest extends UpyunBaseRequest {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
