package me.ruici.upyun;

import me.ruici.upyun.http.HttpMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class HttpMethodValue {

    @Test
    public void testHttpGetValue() {
        assertEquals(HttpMethod.GET.toString(), "GET");
    }

    @Test
    public void testHttpPostValue() {
        assertEquals(HttpMethod.POST.toString(), "POST");
    }

    @Test
    public void testHttpPutValue() {
        assertEquals(HttpMethod.PUT.toString(), "PUT");
    }

    @Test
    public void testHttpDeleteValue() {
        assertEquals(HttpMethod.DELETE.toString(), "DELETE");
    }

    @Test
    public void testHttpHeadValue() {
        assertEquals(HttpMethod.HEAD.toString(), "HEAD");
    }
}
