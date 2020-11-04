package github.com.vangreat.pre_project_web.controller;

import github.com.vangreat.pre_project_web.model.User;
import github.com.vangreat.pre_project_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class PageRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> allUsers = userService.getAllUsers();
        return allUsers != null && !allUsers.isEmpty()
                ? new ResponseEntity<>(allUsers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/admin/{id}")
    public User selectUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/admin")
    public void addNewUser(@RequestBody User user,
                           @RequestParam("role") String role) {
        userService.createUser(user, role);
    }

    @PutMapping("/admin/{id}")
    public void editUser(@PathVariable Long id,
                         @RequestBody User user,
                         @RequestParam("role") String role) {
        userService.editUser(id, user, role);
    }

    @DeleteMapping("/admin/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
