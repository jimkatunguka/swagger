package jim.katunguka.swagger.controller;

import jim.katunguka.swagger.model.User;
import jim.katunguka.swagger.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        return userService.addUser(user);
    }


}
