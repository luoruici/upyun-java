package me.ruici.upyun;

import com.google.common.io.ByteStreams;
import me.ruici.upyun.model.UpyunObject;
import me.ruici.upyun.service.GetObjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

@RunWith(JUnit4.class)
public class GetObject {

    private GetObjectService getObjectService;

    @Before
    public void init() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("upyun.properties");
        Properties p = new Properties();
        p.load(in);
        UpyunConfig config = new UpyunConfig(
                p.getProperty("username"),
                p.getProperty("password"),
                p.getProperty("bucketName")
        );
        this.getObjectService = new GetObjectService(config);
    }

    @Test
    public void getObjectAndSave() throws IOException {
        UpyunObject obj = this.getObjectService.getObject("/static/img/favicon.ico");

        OutputStream out = new FileOutputStream("favicon.ico");
        try {
            ByteStreams.copy(obj.getContent(), out);
        } finally {
            out.close();
            obj.close();
        }
    }
}
