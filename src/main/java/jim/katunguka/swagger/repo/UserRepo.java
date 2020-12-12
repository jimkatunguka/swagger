package jim.katunguka.swagger.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jim.katunguka.swagger.model.User;

public interface UserRepo  extends JpaRepository<User, Long>{

}
