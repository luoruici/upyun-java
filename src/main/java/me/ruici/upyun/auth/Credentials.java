package me.ruici.upyun.auth;

public interface Credentials {

    /**
     * the operator name of Upyun
     *
     * @return operator name
     */
    public String getUsername();

    /**
     * the operator password of Upyun
     * @return
     */
    public String getPassword();
}
