package me.ruici.upyun;

import com.google.common.io.Files;
import me.ruici.upyun.service.UploadObjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;

@RunWith(JUnit4.class)
public class UploadObject extends BaseTest {

    private UploadObjectService uploadObjectService;

    @Before
    @Override
    public void init() throws IOException {
        super.init();
        this.uploadObjectService = new UploadObjectService(this.config);
    }

    @Test
    public void uploadObjectSuccessfully() throws IOException {
        byte[] data = Files.toByteArray(new File("src/test/resources/IMG_0895.JPG"));

        this.uploadObjectService.uploadObject("/IMG_0900.JPG", data);
    }
}
