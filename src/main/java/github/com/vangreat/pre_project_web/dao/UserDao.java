package github.com.vangreat.pre_project_web.dao;

import github.com.vangreat.pre_project_web.model.Role;
import github.com.vangreat.pre_project_web.model.User;

import java.util.List;

public interface UserDao {
    void createUser(String name, String surname, String login, String password, String role);

    void editUser(User user);

    void deleteUser(Long id);

    User getUser(Long id);

    List<User> getAllUsers();

    User getUserByLogin(String login);

    Role getRoleByName(String name);
}