package me.ruici.upyun.auth;

import com.google.common.base.Preconditions;

public class BasicUpyunSignCredentials {

    private String username;

    private String password;

    public BasicUpyunSignCredentials(String username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
