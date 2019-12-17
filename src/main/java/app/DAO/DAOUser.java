package app.DAO;

import app.database.DbConn;
import app.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUser implements DAO<User> {

    List<User> users = new ArrayList<User>();
    String userId;
    String email;
    String password;
    String firstName;
    String lastName;
    String image;
    int age;
    @Override
    public User get(int id) {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT email, password,firstname,lastname,age,image from users where userId=userId");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                email = rs.getString(id);
                password = rs.getString(id);
                firstName=rs.getString(id);
                lastName=rs.getString(id);
                age=rs.getInt(id);
                image=rs.getString(id);
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return new User(email, password, firstName, lastName, age, image);
    }

    @Override
    public List<User> getAll() {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * from users");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
                password = rs.getString("password");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                age = rs.getInt("age");
                image = rs.getString("image");

                users.add(new User(email, password, firstName, lastName, age, image));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return users;
    }

    @Override
    public void put(User o) {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO users (email, password,firstName,lastName,age,image) VALUES  (?, ?, ?, ?, ?, ?)");
            st.setString(1, o.getEmail());
            st.setString(2, o.getPassword());
            st.setString(3, o.getFirstName());
            st.setString(4, o.getLastName());
            st.setInt(5, o.getAge());
            st.setString(6, o.getImage());
            st.execute();
        } catch (SQLException se) {
            throw new IllegalArgumentException(" DAO<User>, put method sql error", se);
        }
    }

    @Override
    public void delete(int id) {
        throw new IllegalArgumentException("DAO<User>:delete hasn't implemented");
    }

    @Override
    public User get(String email) {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * from users where email=email");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
                password = rs.getString("password");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                age = rs.getInt("age");
                image = rs.getString("image");
                userId=rs.getString("userId");
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return new User(userId, email, password, firstName, lastName, age, image);
    }
}
