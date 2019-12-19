package app.DAO;

import app.database.DbConn;
import app.entity.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMessage {
    List<Message> messages = new ArrayList<>();
    int from;
    int to;
    String content;

    public List<Message> get(int fromwho,int towhom) {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT content from messages where fromuser=? AND touser=?");
            st.setInt(1,fromwho);
            st.setInt(2,towhom);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                content=rs.getString("content");
                messages.add(new Message(content));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return messages;

    }

    public List<Message> getAll() {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * from messages");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                from = rs.getInt("fromuser");
                to = rs.getInt("touser");
                content=rs.getString("content");
                messages.add(new Message(from, to,content));
            }
        } catch (SQLException se) {
            throw new IllegalArgumentException("DAO<User>, get method sql error", se);
        }
        return messages;
    }

    public void put(Message message) {
        try {
            Connection conn = DbConn.getConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO messages (fromuser, touser,content) VALUES  (?, ?, ?)");
            st.setInt(1, message.getFromUser());
            st.setInt(2, message.getToUser());
            st.setString(3, message.getContent());
            st.execute();
        } catch (SQLException se) {
            throw new IllegalArgumentException(" DAO<Message>, put method sql error", se);
        }
    }


    public void delete(int id) {
        throw new IllegalArgumentException("DAO<Message>:delete hasn't implemented");
    }

    public Message get(String email) {
        return null;
    }
}
