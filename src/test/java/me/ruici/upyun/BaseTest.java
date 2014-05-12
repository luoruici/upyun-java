package me.ruici.upyun;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    protected UpyunConfig config;

    public void init() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("upyun.properties");
        Properties p = new Properties();
        p.load(in);
        this.config = new UpyunConfig(
                p.getProperty("username"),
                p.getProperty("password"),
                p.getProperty("bucketName")
        );

    }
}
