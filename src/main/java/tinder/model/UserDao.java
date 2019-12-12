package tinder.model;


import tinder.DbConn;
import tinder.UserBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements Dao<UserBean> {

    @Override
    public void store(String email,String password) {
        String sql = "INSERT INTO users(email, password) VALUES (?,?)";

        try {
            PreparedStatement stm = DbConn.get().prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
