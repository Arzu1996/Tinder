package app.service;

import app.DAO.DAOLiked;
import app.entity.Liked;

import java.sql.SQLException;
import java.util.List;

public class LikedService {
    private final DAOLiked daoLiked;

    public LikedService(DAOLiked daoLiked) {
        this.daoLiked = daoLiked;
    }

    public List<Liked> getById(int id) throws SQLException {
        return daoLiked.get(id);
    }
}
