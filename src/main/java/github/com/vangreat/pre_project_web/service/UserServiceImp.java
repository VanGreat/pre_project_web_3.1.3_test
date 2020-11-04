package github.com.vangreat.pre_project_web.service;

import github.com.vangreat.pre_project_web.dao.UserDao;
import github.com.vangreat.pre_project_web.model.Role;
import github.com.vangreat.pre_project_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user, String role) {
        userDao.createUser(user, role);
    }

    @Override
    public void editUser(Long id, User user, String role) {
        userDao.editUser(id, user, role);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(Long id, String firstName, String lastName, Byte age, String email, String password, String role) {
        userDao.updateUser(id, firstName, lastName, age, email, password, role);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public Role getRoleByName(String name) {
        return userDao.getRoleByName(name);
    }
}
