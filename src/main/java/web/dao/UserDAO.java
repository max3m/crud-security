package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
