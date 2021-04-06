package web.service;

import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(Long id) {
        return userDAO.show(id);
    }

    @Override
    public void save(User user) { userDAO.save(user); }

    @Override
    public void update(Long id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
