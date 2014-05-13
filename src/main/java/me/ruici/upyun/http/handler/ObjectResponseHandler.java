package me.ruici.upyun.http.handler;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import me.ruici.upyun.http.Headers;
import me.ruici.upyun.http.UpyunHttpResponse;
import me.ruici.upyun.http.UpyunHttpResponseHandler;
import me.ruici.upyun.model.ObjectMetadata;
import me.ruici.upyun.model.UpyunObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ObjectResponseHandler implements UpyunHttpResponseHandler<UpyunObject> {

    public static final Logger logger = LoggerFactory.getLogger(ObjectResponseHandler.class);

    public static void getObjectMetadata(UpyunHttpResponse response, ObjectMetadata metadata) {
        for (String key : response.getHeaders().keySet()) {
            String value = response.getHeaders().get(key);
            if (key == null) {
                continue;
            }
            if (key.equals(Headers.UPYUN_FILE_TYPE)) {
                metadata.setType(ObjectMetadata.ObjectType.fromString(value));
            } else if (key.equals(Headers.UPYUN_FILE_SIZE)) {
                metadata.setSize(Ints.tryParse(value));
            } else if (key.equals(Headers.UPYUN_FILE_DATE)) {
                metadata.setCreated(new Date(Longs.tryParse(value) * TimeUnit.SECONDS.toMillis(1)));
            }
        }
    }

    @Override
    public UpyunObject handle(UpyunHttpResponse response) {
        UpyunObject object = new UpyunObject();
        getObjectMetadata(response, object.getMetadata());

        object.setContent(response.getContent());

        return object;
    }
}
