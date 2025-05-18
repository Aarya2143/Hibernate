package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainFile {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("ManyToMany.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestions("What is java");

        Question q2 = new Question();
        q2.setQuestions("Tell me About java");

        Answer a1 = new Answer();
        a1.setAnswer("Java is programming language");

        Answer a2 = new Answer();
        a2.setAnswer("Java is use to develop software");

        List<Answer> answerlist = new ArrayList<>();
        answerlist.add(a1);
        answerlist.add(a2);

        q1.setAnswers(answerlist);
        q2.setAnswers(answerlist);

        List<Question> questionlist = new ArrayList<>();
        questionlist.add(q1);
        questionlist.add(q2);

        a1.setQuestion(questionlist);
        a2.setQuestion(questionlist);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(q2);
        session.save(a1);
        session.save(a2);

        tx.commit();
        session.close();
        factory.close();
    }
}
