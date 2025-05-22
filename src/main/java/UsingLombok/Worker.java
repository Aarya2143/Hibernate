package UsingLombok;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String company;
    private double salary;
}
