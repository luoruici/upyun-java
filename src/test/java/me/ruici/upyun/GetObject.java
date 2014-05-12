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
import java.io.OutputStream;

@RunWith(JUnit4.class)
public class GetObject extends BaseTest {

    private GetObjectService getObjectService;

    @Before
    @Override
    public void init() throws IOException {
        super.init();
        this.getObjectService = new GetObjectService(this.config);
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
