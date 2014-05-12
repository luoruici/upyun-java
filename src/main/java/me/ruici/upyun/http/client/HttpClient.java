package me.ruici.upyun.http.client;

import com.github.kevinsawicki.http.HttpRequest;
import me.ruici.upyun.auth.Credentials;
import me.ruici.upyun.auth.Signer;
import me.ruici.upyun.auth.UpyunHttpSigner;
import me.ruici.upyun.http.HttpMethod;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.UpyunHttpResponse;
import me.ruici.upyun.http.UpyunHttpResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class HttpClient {

    public static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

    private static final String HTTP_SCHEME = "http://";

    private static UpyunHttpResponse doHttpAction(String url, HttpMethod method, Map<String, String> headers) {
        HttpRequest request = new HttpRequest(url, method.toString()).headers(headers);
        UpyunHttpResponse response = new UpyunHttpResponse();
        response.setStatusCode(request.code());
        response.setStatusText(request.message());
        response.setContent(request.stream());

        logger.debug("request {} with method {} has result code : {}", url, method, response);
        return response;
    }

    private static Signer getSigner(UpyunHttpRequest request) {
        return new UpyunHttpSigner(request.getHttpMethod().toString(), request.getResourcePath());
    }

    public static <X> X execute(String endpoint, UpyunHttpRequest request,
                                UpyunHttpResponseHandler<X> responseHandler,
                                Credentials credentials) {
        getSigner(request).sign(request, credentials);
        String url = String.format("%s%s%s", HTTP_SCHEME, endpoint, request.getResourcePath());
        UpyunHttpResponse response = doHttpAction(url, request.getHttpMethod(), request.getHeaders());
        return responseHandler.handle(response);
    }

}
