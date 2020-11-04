//package github.com.vangreat.pre_project_web.controller;
//
//import github.com.vangreat.pre_project_web.model.User;
//import github.com.vangreat.pre_project_web.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminsController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/rest")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/rest/{id}")
//    public User getUser(@PathVariable Long id) {
//        return userService.getUser(id);
//    }
//
//    @PostMapping("/rest")
//    public void addNewUser(@RequestParam("firstName") String firstName,
//                                        @RequestParam("lastName") String lastName,
//                                        @RequestParam("age") Byte age,
//                                        @RequestParam("email") String email,
//                                        @RequestParam("password") String password,
//                                        @RequestParam("role") String role) {
//        userService.createUser(firstName, lastName, age, email, password, role);
//    }
//
//
//    @PutMapping(value = "/edit/{id}")
//    public void editUser(@PathVariable Long id,
//                                      @RequestParam("firstName") String firstName,
//                                      @RequestParam("lastName") String lastName,
//                                      @RequestParam("age") Byte age,
//                                      @RequestParam("email") String email,
//                                      @RequestParam("password") String password,
//                                      @RequestParam("role") String role) {
//        userService.updateUser(id, firstName, lastName, age, email, password, role);
//    }
//
//    @DeleteMapping("/rest/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }
//}