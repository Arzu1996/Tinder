package app.service;

import app.DAO.DAOUser;
import app.entity.User;

import java.io.PrintWriter;
import java.util.List;

public class LoginService {
    DAOUser daoUser = new DAOUser();
    PrintWriter writer;

    public boolean checkLogin(String email, String pass) {
        List<User> all = daoUser.getAll();
        boolean found = false;
        for (User u : all) {
            if (u.getEmail().equals(email)
                    && u.getPassword().equals(pass)) {
                found = true;
                break;
            }
        }
        return found;
    }

}
