package com.jberry.services.tools;

import com.google.gson.Gson;
import com.jberry.dto.Insulin;
import com.jberry.dto.User;
import org.apache.commons.codec.binary.Base64;

public class ToolService {
    public String userEncoded(){
        User notandi = User.getTheUser();
        Base64 b64 = new Base64();
        String usr = notandi.getEmail() + ":" + notandi.getPassword();
        return b64.encodeAsString(usr.getBytes());
    }
    public String url(){
        return "localhost";
    }
}
