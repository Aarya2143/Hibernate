package fetch_type;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "que", fetch = FetchType.EAGER)
    private List<Answers> ans = new ArrayList<>();
}
