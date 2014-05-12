package me.ruici.upyun.auth;

import me.ruici.upyun.http.HttpRequest;

public interface Signer {

    public void sign(HttpRequest request, Credentials credentials);
}
