//package github.com.vangreat.pre_project_web.controller;
//
//import github.com.vangreat.pre_project_web.model.User;
//import github.com.vangreat.pre_project_web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping
//public class GuestsController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public String loginIn() {
//        return "login";
//    }
//
//    @GetMapping("/main")
//    public String getPage() {
//        return "main";
//    }
//
//    @RequestMapping("/admin")
//    public String getAdmin(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("user", user);
//        model.addAttribute("users", userService.getAllUsers());
//        return "main";
//    }
//
//    @RequestMapping("/user")
//    public String getUser(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("user", user);
//        return "main";
//    }
//}