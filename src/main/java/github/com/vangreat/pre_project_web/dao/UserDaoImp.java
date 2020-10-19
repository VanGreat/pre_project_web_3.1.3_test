package github.com.vangreat.pre_project_web.dao;

import github.com.vangreat.pre_project_web.model.Role;
import github.com.vangreat.pre_project_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void createUser(String name, String surname, String login, String password, String role) {
        User user = new User(name, surname, login, password);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(new HashSet<>());

        if (role.equals("ROLE_ADMIN")) {
            user.getRoles().add(getRoleByName("ROLE_ADMIN"));
            user.getRoles().add(getRoleByName("ROLE_USER"));
        } else {
            user.getRoles().add(getRoleByName("ROLE_USER"));
        }
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        user.setPasswordConfirm(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPasswordConfirm()));
        user.setRoles(getUserByLogin(user.getLogin()).getRoles());
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> listUsers = (List<User>) entityManager.createQuery("SELECT u FROM User u").getResultList();
        return listUsers;
    }

    @Override
    public User getUserByLogin(String login) {
        return getAllUsers().stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst()
                .get();
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("SELECT r FROM Role r WHERE r.name = :name")
                .setParameter("name", name).getSingleResult();
    }
}
