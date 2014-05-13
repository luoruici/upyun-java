package me.ruici.upyun;

import com.google.common.io.Files;
import me.ruici.upyun.service.DeleteObjectService;
import me.ruici.upyun.service.UploadObjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;

@RunWith(JUnit4.class)
public class DeleteObject extends BaseTest {

    private DeleteObjectService deleteObjectService;

    private UploadObjectService uploadObjectService;

    @Before
    @Override
    public void init() throws IOException {
        super.init();
        this.deleteObjectService = new DeleteObjectService(this.config);
        this.uploadObjectService = new UploadObjectService(this.config);
    }

    @Test
    public void deleteObjectSuccessfully() throws IOException {
        //Upload an object first
        String deletedFile = "/deletedfile.jpg";
        byte[] data = Files.toByteArray(new File("src/test/resources/IMG_0895.JPG"));
        this.uploadObjectService.uploadObject(deletedFile, data);

        this.deleteObjectService.deleteObject(deletedFile);
    }

    @Test(expected = UpyunException.class)
    public void deleteNotExistObject() {
        this.deleteObjectService.deleteObject("/fdjakfjdkafja");
    }
}
