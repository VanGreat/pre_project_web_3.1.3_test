package github.com.vangreat.pre_project_web.controller;

import github.com.vangreat.pre_project_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class GuestsController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginIn() {
        return "login";
    }

    @GetMapping("/new_user")
    public String newUser() {
        return "new_user";
    }

    @PostMapping("/new_user")
    public String createUser(@RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("login") String login,
                             @RequestParam("password") String password,
                             @RequestParam("role") String role) {
        userService.createUser(name, surname, login, password, role);
        return "redirect:/new_user";
    }
}
