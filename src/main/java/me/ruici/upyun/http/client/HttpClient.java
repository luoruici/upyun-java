package me.ruici.upyun.http.client;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import me.ruici.upyun.UpyunException;
import me.ruici.upyun.auth.Credentials;
import me.ruici.upyun.auth.Signer;
import me.ruici.upyun.auth.UpyunHttpSigner;
import me.ruici.upyun.http.UpyunHttpRequest;
import me.ruici.upyun.http.UpyunHttpResponse;
import me.ruici.upyun.http.UpyunHttpResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class HttpClient {

    public static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

    private static final String HTTP_SCHEME = "http://";

    private static boolean isRequestSuccessful(UpyunHttpResponse response) {
        return response.getStatusCode() / 100 == 2;
    }

    private static UpyunHttpResponse doResponse(HttpRequest request) throws UpyunException {
        UpyunHttpResponse response = new UpyunHttpResponse();
        try {
            response.setStatusCode(request.code());
            response.setStatusText(request.message());
            response.setContent(request.stream());
            logger.debug("response code is {}", response.getStatusCode());
            if (!isRequestSuccessful(response)) {
                UpyunException upyunException = new UpyunException();
                upyunException.setStatusCode(response.getStatusCode());
                upyunException.setErrorCode(response.getStatusText());
                if (response.getContent() != null) {
                    String content = CharStreams.toString(new InputStreamReader(response.getContent(), Charsets.UTF_8));
                    upyunException.setErrorMessage(content);
                    response.getContent().close();
                }
                throw upyunException;
            }
        } catch (HttpRequest.HttpRequestException httpRequestException) {
            IOException ioException = httpRequestException.getCause();
            logger.error("http request exception", ioException);
            throw new UpyunException(ioException);
        } catch (IOException ioException) {
            logger.error("http request exception", ioException);
            throw new UpyunException(ioException);
        }

        return response;
    }

    private static UpyunHttpResponse doGet(String url, Map<String, String> headers, Map<String, String> parameters)
            throws UpyunException {
        HttpRequest request = HttpRequest.get(url, parameters, true).headers(headers);

        return doResponse(request);
    }

    private static UpyunHttpResponse doPost(String url, Map<String, String> headers,
                                            Map<String, String> parameters,
                                            Map<String, String> forms)
            throws UpyunException {
        HttpRequest request = HttpRequest.post(url, parameters, true).headers(headers).form(forms);

        return doResponse(request);
    }

    private static Signer getSigner(UpyunHttpRequest request) {
        return new UpyunHttpSigner(request.getHttpMethod().toString(), request.getResourcePath());
    }

    public static <X> X execute(String endpoint, UpyunHttpRequest request,
                                UpyunHttpResponseHandler<X> responseHandler,
                                Credentials credentials)
            throws UpyunException {
        getSigner(request).sign(request, credentials);
        String url = String.format("%s%s%s", HTTP_SCHEME, endpoint, request.getResourcePath());
        UpyunHttpResponse response = null;
        switch (request.getHttpMethod()) {
            case GET:
                response = doGet(url, request.getHeaders(), request.getParameters());
                break;
            case POST:
                response = doPost(url, request.getHeaders(), request.getParameters(), request.getForms());
                break;
            case PUT:
                break;
            case DELETE:
                break;
            case HEAD:
                break;
            default:
                throw new UpyunException("Unsupported Http Action");
        }
        return responseHandler.handle(response);
    }

}
