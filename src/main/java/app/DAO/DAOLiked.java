package app.DAO;

import app.entity.Liked;
import app.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class DAOLiked implements DAO<Liked> {

    @Override
    public Liked get(int id) {
        throw new IllegalArgumentException("DAO<Liked>:get hasn't implemented");

    }

    @Override
    public List<Liked> getAll() {
        throw new IllegalArgumentException("DAO<Liked>:getAll hasn't implemented");
    }

    @Override
    public void put(Liked liked) {
        throw new IllegalArgumentException("DAO<Liked>:put hasn't implemented");
    }

    @Override
    public void delete(int id) {
        throw new IllegalArgumentException("DAO<Liked>:delete hasn't implemented");

    }

    @Override
    public Liked get(String email) {
        return null;
    }
}
