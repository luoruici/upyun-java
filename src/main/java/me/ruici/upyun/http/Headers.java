package me.ruici.upyun.http;

/**
 * Standard HTTP Header Definition
 */
public interface Headers {

    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_MD5 = "Content-MD5";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DATE = "Date";
    public static final String ETAG = "ETag";
    public static final String LAST_MODIFIED = "Last-Modified";
    public static final String SERVER = "Server";

    /* Upyun File Info Header */
    public static final String UPYUN_FILE_TYPE = "x-upyun-file-type";
    public static final String UPYUN_FILE_SIZE = "x-upyun-file-size";
    public static final String UPYUN_FILE_DATE = "x-upyun-file-date";

    /* Upyun Image Response Header */
    public static final String UPYUN_WIDTH = "x-upyun-width";
    public static final String UPYUN_HEIGHT = "x-upyun-height";
    public static final String UPYUN_FRAMES = "x-upyun-frames";
    public static final String UPYUN_IMAGE_FILE_TYPE = "x-upyun-file-type";

}
