package ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    @Column(name = "")
    private int answerId;

    private String answer;

    @ManyToMany(mappedBy = "answers")
    private List<Question> question;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public Answer(int answerId, String answer, List<Question> question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = (List<Question>) question;
    }

    public Answer() {
        super();
    }
}
