package me.ruici.upyun.http;


public interface UpyunHttpResponseHandler<T> {

    public T handle(UpyunHttpResponse response);
}
