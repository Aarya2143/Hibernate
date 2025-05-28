package validations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ValidationsDemo {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "You need to enter name")
    private String name;

    @Email(message = "Invalid mail id")
    private String email;

    @Length(max = 10, min = 10, message = "Number must have 10 digit")
    private String number;

    @Pattern(regexp = "^\\d{2}\\d{2}\\d{4}$", message = "Birthdate must be in ddMMyyyy format")
    private String birthadate;
}
