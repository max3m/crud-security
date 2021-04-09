package web.service;

import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    Set<User> allUsers();
    User getById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
}

