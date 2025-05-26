package fetch_type;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answers {

    @Id
    private int answerId;

    private String answer;

    @ManyToOne
    private Question que;

}
