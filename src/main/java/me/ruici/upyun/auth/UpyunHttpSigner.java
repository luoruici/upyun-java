package me.ruici.upyun.auth;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import me.ruici.upyun.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class UpyunHttpSigner implements Signer {

    public static final Logger logger = LoggerFactory.getLogger(UpyunHttpSigner.class);

    private final String httpMethodName;

    private final String resourcePath;

    public UpyunHttpSigner(String httpMethodName, String resourcePath) {
        this.httpMethodName = httpMethodName;
        this.resourcePath = resourcePath;

        if (resourcePath == null) {
            throw new IllegalArgumentException("Parameter resourcePath is null");
        }
    }

    @Override
    public void sign(HttpRequest request, Credentials credentials) {
        if (credentials == null) {
            logger.error("Canonical String will not be signed, as no credentials was provided");
            return;
        }
        String date = getGMTDate();
        request.addHeader("Date", date);
        String signature = Joiner.on('&').join(this.httpMethodName, this.resourcePath, date, request.getContentLength(),
                md5(credentials.getPassword()));

        request.addHeader("Authorization", String.format("Upyun %s:%s", credentials.getUsername(), md5(signature)));


    }

    private String md5(String str) {
        HashFunction hf = Hashing.md5();

        return hf.newHasher()
                .putString(str, Charsets.UTF_8)
                .hash()
                .toString();
    }

    private String getGMTDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(
                "EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formatter.format(new Date());
    }

}
