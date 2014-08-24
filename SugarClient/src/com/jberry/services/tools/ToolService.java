package com.jberry.services.tools;

import com.jberry.dto.User;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

public class ToolService {
    public String userEncoded(){
        User notandi = User.getTheUser();
        Base64 b64 = new Base64();
        String usr = notandi.getEmail() + ":" + notandi.getPassword();
        String user = new String(b64.encodeBase64(StringUtils.getBytesUtf8(usr)));

        return user;
    }
    public String url(){
        return "jberry.noip.me";
    }
}
