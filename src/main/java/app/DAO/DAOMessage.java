package app.DAO;

import app.entity.Message;

import java.util.List;

public class DAOMessage implements DAO<Message> {

    @Override
    public Message get(int id) {
        throw new IllegalArgumentException("DAO<Message>:get hasn't implemented");
    }

    @Override
    public List<Message> getAll() {
        throw new IllegalArgumentException("DAO<Message>:getAll hasn't implemented");
    }

    @Override
    public void put(Message message) {
        throw new IllegalArgumentException("DAO<Message>:put hasn't implemented");
    }

    @Override
    public void delete(int id) {
        throw new IllegalArgumentException("DAO<Message>:delete hasn't implemented");
    }

    @Override
    public Message get(String email) {
        return null;
    }
}
