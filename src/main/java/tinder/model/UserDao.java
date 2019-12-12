package tinder.model;


import tinder.DbConn;
import tinder.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<UserBean> {

    private Connection connection= DbConn.get();
    @Override
    public void store(UserBean entity) {

    }

    @Override
    public void update(UserBean entity) {

    }

    @Override
    public void delete(int id) {

    }

    public boolean existByEmailAndPass(String email, String pass) {
        String sql = "SELECT * FROM users WHERE email='"+email+"'";
        boolean answ = false;

        try(PreparedStatement statement = DbConn.get().prepareStatement(sql);
            ResultSet rSet = statement.executeQuery()){

            while(rSet.next()) {
                if(rSet.getString("email").equals(email)
                        && rSet.getString("password").equals(pass)){
                    answ = true;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return answ;
    }
}
