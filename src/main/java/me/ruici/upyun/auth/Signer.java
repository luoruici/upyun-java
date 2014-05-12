package me.ruici.upyun.auth;

import me.ruici.upyun.http.UpyunHttpRequest;

public interface Signer {

    public void sign(UpyunHttpRequest request, Credentials credentials);
}
