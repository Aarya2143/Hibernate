package ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class MainResult {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("ManyToOne.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Answer answer = new Answer();
        answer.setAnswer("java is a programming language");

        Question q1 = new Question();
        q1.setQuestion("what is java");
        q1.setAnswer(answer);

        Question q2 = new Question();
        q2.setQuestion("Tell me about java");
        q2.setAnswer(answer);

        List<Question> list = new ArrayList<>();
        list.add(q1);
        list.add(q2);

        answer.setQuestion(list);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(q2);
        session.save(answer);

        tx.commit();
        session.close();
        factory.close();
    }
}
