package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("OneToOne.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is java ?");

        Answer a1 = new Answer();
        a1.setAnswerId(343);
        a1.setAnswer("Java is programming language.");

        q1.setAnswer(a1);
        a1.setQuestion(q1);

        //creating question
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("What is Collection framework ?");

        Answer a2 = new Answer();
        a2.setAnswerId(1234);
        a2.setAnswer("API to work with object in java.");

        q2.setAnswer(a2);
        a2.setQuestion(q2);

        //session
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        //save
        s.save(q1);
        s.save(q2);
        s.save(a1);
        s.save(a2);


        tx.commit();

        s.close();

        factory.close();
    }

}
