package app.DAO;

import app.database.DbConn;
import app.entity.Liked;
import app.entity.Message;
import app.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLiked implements DAO<Liked> {
    List<Liked> liked = new ArrayList<>();
    int likedId;
    int fromWho;
    int toWhom;
    @Override
    public Liked get(int id) {
        throw new IllegalArgumentException("DAO<Liked>:get hasn't implemented");

    }

    @Override
    public List<Liked> getAll() {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * from liked");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                likedId = rs.getInt("liked");
                fromWho = rs.getInt("fromwho");
                toWhom = rs.getInt("towhom");

                liked.add(new Liked(likedId, fromWho, toWhom));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return liked;
    }

    @Override
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

    @Override
    public void delete(int id) {
        throw new IllegalArgumentException("DAO<Liked>:delete hasn't implemented");

    }

    @Override
    public Liked get(String email) {
        return null;
    }
}
