package jim.katunguka.swagger.service;

import jim.katunguka.swagger.model.User;
import jim.katunguka.swagger.repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public ResponseEntity<?> addUser(User user){
        User response = userRepo.save(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
