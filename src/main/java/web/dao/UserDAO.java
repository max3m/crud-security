package web.dao;

import web.model.User;

import java.util.Set;

public interface UserDAO {
    Set<User> allUsers();
    User getById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
    User getUserByName(String username);
}
