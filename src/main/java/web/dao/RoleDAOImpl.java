package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public RoleDAOImpl() {
    }

    @Override
    public void save(Role role) {
        Role managed = entityManager.merge(role);
        entityManager.persist(managed);
    }

    @Override
    public void delete(Role role) {
        Role managed = entityManager.merge(role);
        entityManager.remove(managed);
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class, id );
    }

    @Override
    public Role getRoleByName(String rolename) {
        try{
            Role role = entityManager.createQuery("SELECT r FROM Role r where r.name = :name", Role.class)
                    .setParameter("name", rolename)
                    .getSingleResult();
            return role;
        } catch (NoResultException ex){
            return null;
        }
    }

    public Set<Role> getRoleSet() {
        try{
            return new HashSet<Role>(entityManager.createQuery("SELECT r FROM Role r", Role.class)
                    .getResultList());
        } catch (NoResultException ex){
            return null;
        }
    }

}