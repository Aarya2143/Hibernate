package Casecading;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "que", cascade = CascadeType.ALL)
    private List<Answer> ans;
}
