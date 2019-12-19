package app.DAO;

import app.database.DbConn;
import app.entity.Liked;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLiked  {
    List<Liked> liked = new ArrayList<>();
    int likedId;
    int fromWho;
    int toWhom;

    public List<Liked> get(int id) {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT likedid, towhom from liked where fromwho=? ");
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                likedId = rs.getInt(id);
                toWhom = rs.getInt(id);
                liked.add(new Liked(likedId, toWhom));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return liked;

    }


    public List<Liked> getAll() {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * from liked");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                fromWho = rs.getInt("fromwho");
                toWhom = rs.getInt("towhom");

                liked.add(new Liked(fromWho, toWhom));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return liked;
    }


    public void put(Liked liked) {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO liked (fromwho, towhom) VALUES  (?, ?)");
            st.setInt(1, liked.getFromWho());
            st.setInt(2, liked.getToWhom());
            st.execute();
        } catch (SQLException se) {
            throw new IllegalArgumentException(" DAO<Liked>, put method sql error", se);
        }    }


    public void delete(int id) {
        throw new IllegalArgumentException("DAO<Liked>:delete hasn't implemented");

    }


}
