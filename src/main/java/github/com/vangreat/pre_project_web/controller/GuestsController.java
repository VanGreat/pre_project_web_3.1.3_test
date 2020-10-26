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

    @GetMapping("/")
    public String loginIn() {
        return "login";
    }

    @GetMapping("/new_user")
    public String newUser() {
        return "new_user";
    }

    @PostMapping("/new_user")
    public String createUser(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("age") Byte age,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("role") String role) {
        userService.createUser(firstName, lastName, age, email, password, role);
        return "redirect:/new_user";
    }
}