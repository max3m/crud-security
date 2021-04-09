package web.dao;

import web.model.Role;
import web.model.User;

import java.util.Set;

public interface RoleDAO {
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String rolename);
    Set<Role> getRoleSet();
}