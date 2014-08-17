package com.jberry.services.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import com.jberry.dto.User;

public interface UserService {
	boolean login(String username, String password) throws Exception;
}
