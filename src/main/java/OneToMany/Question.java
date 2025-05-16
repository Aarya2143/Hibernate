package OneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {

    @Id
    @Column(name = "que_id")
    @GeneratedValue
    private int Questionid;

    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public int getQuestionid() {
        return Questionid;
    }

    public void setQuestionid(int questionid) {
        Questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(int questionid, String question, List<Answer> answers) {
        Questionid = questionid;
        this.question = question;
        this.answers = answers;
    }

    public Question() {
        super();
    }
}
