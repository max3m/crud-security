package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    User getById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);
}

