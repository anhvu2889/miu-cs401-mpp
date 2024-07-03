package midterm.controller;

import midterm.exception.LoginException;

import java.util.List;

public interface UserController {
    public void login(String id, String password) throws LoginException;

    public List<String> getAllMemberIds();
}
