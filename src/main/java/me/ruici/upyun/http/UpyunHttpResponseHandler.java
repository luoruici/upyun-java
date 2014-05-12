package me.ruici.upyun.http;


public interface UpyunHttpResponseHandler<T> {

    public static final UpyunHttpResponseHandler<Void> VOID_RESPONSE_HANDLER = new UpyunHttpResponseHandler<Void>() {
        @Override
        public Void handle(UpyunHttpResponse response) {
            //Do nothing
            return null;
        }
    };

    public T handle(UpyunHttpResponse response);
}
