package me.ruici.upyun.handler;

import me.ruici.upyun.http.UpyunHttpResponse;
import me.ruici.upyun.http.UpyunHttpResponseHandler;
import me.ruici.upyun.model.ObjectMetadata;

public class ObjectMetadataResponseHandler implements UpyunHttpResponseHandler<ObjectMetadata> {

    @Override
    public ObjectMetadata handle(UpyunHttpResponse response) {
        ObjectMetadata metadata = new ObjectMetadata();
        ObjectResponseHandler.getObjectMetadata(response, metadata);
        
        return metadata;
    }
}
