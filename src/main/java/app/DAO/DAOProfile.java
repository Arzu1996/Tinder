package app.DAO;

import app.entity.Profile;

import java.util.ArrayList;
import java.util.List;

public class DAOProfile implements DAO<Profile> {

    @Override
    public Profile get(int id) {
        throw new IllegalArgumentException("DAO<Profile>:get hasn't implemented");
    }

    @Override
    public List<Profile> getAll() {
        throw new IllegalArgumentException("DAO<Profile>:getall hasn't implemented");
    }

    @Override
    public void put(Profile profile) {
        throw new IllegalArgumentException("DAO<Profile>:put hasn't implemented");
    }

    @Override
    public void delete(int id) {
        throw new IllegalArgumentException("DAO<Profile>:delete hasn't implemented");
    }

    @Override
    public Profile get(String email) {
        return null;
    }
}
