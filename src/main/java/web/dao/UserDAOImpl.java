package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static int PEOPLE_COUNT;
    List<User> users = new ArrayList<User>() {
        {
        add(new User(++PEOPLE_COUNT, "Mark", 13, "fefevew@mail.com"));
        add(new User(++PEOPLE_COUNT, "Clark", 24, "feewefwe@ewc.ru"));
        add(new User(++PEOPLE_COUNT, "Dark", 55, "wdafe@fewf.az"));
        add(new User(++PEOPLE_COUNT, "Shark", 45, "feffe@fee.zs"));
        }
    };

    @Override
    public List<User> index() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
