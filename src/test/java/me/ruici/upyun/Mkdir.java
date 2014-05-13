package me.ruici.upyun;

import me.ruici.upyun.service.MkdirService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class Mkdir extends BaseTest {

    private MkdirService mkdirService;

    @Before
    @Override
    public void init() throws IOException {
        super.init();

        this.mkdirService = new MkdirService(this.config);
    }

    @Test(expected = UpyunException.class)
    public void mkdir() {
        this.mkdirService.mkdir("/testerror/expectedexception", false);
    }
}
