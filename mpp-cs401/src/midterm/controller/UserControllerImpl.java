package midterm.controller;

import midterm.exception.LoginException;
import midterm.data.Auth;
import midterm.data.DataAccess;
import midterm.data.DataAccessFacade;
import midterm.data.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserControllerImpl implements UserController {
    public static Auth currentAuth = null;

    public void login(String id, String password) throws LoginException {
        DataAccess da = new DataAccessFacade();
        HashMap<String, User> map = da.readUserMap();
        if (!map.containsKey(id)) {
            throw new LoginException("ID " + id + " not found");
        }
        String passwordFound = map.get(id).getPassword();
        if (!passwordFound.equals(password)) {
            throw new LoginException("Password incorrect");
        }
        currentAuth = map.get(id).getAuthorization();

    }

    @Override
    public List<String> getAllMemberIds() {
        DataAccess da = new DataAccessFacade();
        List<String> retval = new ArrayList<>();
        retval.addAll(da.readMemberMap().keySet());
        return retval;
    }
}
