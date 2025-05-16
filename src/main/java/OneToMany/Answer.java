package OneToMany;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue
    private int answerId;

    private String answers;

    @ManyToOne
    private Question question;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer(int answerId, String answers, Question question) {
        this.answerId = answerId;
        this.answers = answers;
        this.question = question;
    }

    public Answer() {
        super();
    }
}
