package ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "que_id")
    private int questionId;

    private String Questions;

    @ManyToMany
    private List<Answer> answers;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(int questionId, String questions, List<Answer> answers) {
        this.questionId = questionId;
        Questions = questions;
        this.answers = answers;
    }

    public Question() {
        super();
    }
}
