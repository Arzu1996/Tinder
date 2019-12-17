package app.service;

import app.DAO.DAOUser;
import app.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RegisterService {
    DAOUser daoUser = new DAOUser();
    PrintWriter writer;
    public boolean check_register(String email, String pass, String firstName, String lastName, int age, String image) throws IOException {
        List<User> all = daoUser.getAll();
        boolean found = false;
        for (User u : all) {
            if (u.getEmail().equals(email)) {
                found = true;
                break;
            }
        }
        if (!found) {
            User newUser = new User(email, pass,firstName,lastName,age,image);
            daoUser.put(newUser);
            return true;
        }
        return false;
    }
}
