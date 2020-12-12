package jim.katunguka.swagger.service;

import jim.katunguka.swagger.model.User;
import jim.katunguka.swagger.repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public ResponseEntity<?> addUser(User user){
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        User response = userRepo.save(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> getUser(long id){

        Optional<User> response = userRepo.findById(id);
        if(response.isPresent()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return  new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getUsers() {
        try{
            List<User> response = userRepo.findAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Users not found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> deleteUser(long id) {

        try {
            userRepo.deleteById(id);
            return new ResponseEntity<>("User is successfully deleted",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("User not found and therefore not deleted", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> updateUser( long id, User newUser)   {

        if(newUser == null) return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Logger.getLogger("querying the user from the database");
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            Logger.getLogger("editing the received user");
            user.get().setFirstName(newUser.getFirstName());
            user.get().setLastName(newUser.getLastName());
            user.get().setEmail(newUser.getEmail());

            Logger.getLogger("edited user is saved into the database");
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

        //Logger.getLogger("user returned an exception");
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}


