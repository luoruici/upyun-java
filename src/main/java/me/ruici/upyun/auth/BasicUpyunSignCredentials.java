package me.ruici.upyun.auth;

import com.google.common.base.Preconditions;

public class BasicUpyunSignCredentials implements Credentials {

    private String username;

    private String password;

    public BasicUpyunSignCredentials(String username, String password) {
        Preconditions.checkNotNull(username);
        Preconditions.checkNotNull(password);
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
