package tinder.model;



public interface Dao<T> {
    boolean existByEmailAndPass(String email, String pass);
    void store(String email,String password);
    void update(T entity);
    void delete(int id);
}
