package me.ruici.upyun;

import me.ruici.upyun.model.ObjectMetadata;
import me.ruici.upyun.service.GetObjectMetadataService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@RunWith(JUnit4.class)
public class GetObjectMetadata extends BaseTest {

    public static final Logger logger = LoggerFactory.getLogger(GetObjectMetadata.class);

    private GetObjectMetadataService getObjectMetadataService;

    @Before
    @Override
    public void init() throws IOException {
        super.init();
        this.getObjectMetadataService = new GetObjectMetadataService(this.config);
    }

    @Test
    public void getObjectMetadataSuccessfully() {
        ObjectMetadata metadata = this.getObjectMetadataService.getObjectMetadata("/icon/4002871.jpg");

        Assert.assertEquals(ObjectMetadata.ObjectType.FILE, metadata.getType());
        Assert.assertNotNull(metadata.getCreated());
    }

    @Test(expected = UpyunException.class)
    public void getNonExistObjectMetadata() {
        this.getObjectMetadataService.getObjectMetadata("/fdaffda/fdafdafaf.jpg");
    }

    @Test
    public void getDirMetadata() {
        ObjectMetadata metadata = this.getObjectMetadataService.getObjectMetadata("/icon");

        Assert.assertEquals(ObjectMetadata.ObjectType.DIR, metadata.getType());
        Assert.assertNotNull(metadata.getCreated());
    }
}
