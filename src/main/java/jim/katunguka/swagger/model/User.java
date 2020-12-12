package jim.katunguka.swagger.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(value = 3, message ="firstName must be more than 3 characters")
    private String firstName;

    @Min(value = 3, message ="firstName must be more than 3 characters")
    private String lastName;

    @NotNull(message = "email must not be blank")
    private String email;
}
