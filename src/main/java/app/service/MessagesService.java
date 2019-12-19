package app.service;

import app.DAO.DAOMessage;
import app.entity.Message;

import java.sql.SQLException;
import java.util.List;

public class MessagesService {
    private final DAOMessage daoMessage;

    public MessagesService(DAOMessage daoMessage) {
        this.daoMessage = daoMessage;
    }


    public void put(Message message){
        daoMessage.put(message);
    }
    public List<Message> get(int from,int to) throws SQLException {
        return daoMessage.get(from, to);
    }
}
