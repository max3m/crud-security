package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    User getById(Long id);
    void save(User user);
    void update(Long id, User updatedUser);
    void delete(User user);
    User getUserByName(String username);
}
