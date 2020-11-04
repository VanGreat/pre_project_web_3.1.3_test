//package github.com.vangreat.pre_project_web.controller;
//
//import github.com.vangreat.pre_project_web.model.User;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/user")
//public class UsersController {
//
//    @GetMapping(value = "/rest")
//    public User getUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return (User) authentication.getPrincipal();
//    }
//}