package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(entityManager.merge(user));
    }

    @Override
    @Transactional
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
