package me.ruici.upyun;

import com.google.common.base.Objects;

public class UpyunException extends RuntimeException {

    private int statusCode;

    private String errorCode;

    private String errorMessage;

    public UpyunException() {
        super();
    }

    public UpyunException(String message) {
        super();
        this.errorMessage = message;
    }

    public UpyunException(Exception cause) {
        super(null, cause);
        this.errorMessage = cause.getMessage();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("StatusCode", getStatusCode())
                .add("ErrorCode", getErrorCode())
                .add("Message", getErrorMessage())
                .toString();
    }
}
