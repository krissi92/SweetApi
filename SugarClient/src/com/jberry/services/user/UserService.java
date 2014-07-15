package com.jberry.services.user;

import java.util.List;
import com.jberry.dto.User;

public interface UserService {
	boolean login(String username, String password) throws Exception;
	List<User> getUsers();
    boolean register(String username, String password, String email);
    boolean isLoggedIn(String name); //incomplete

}
