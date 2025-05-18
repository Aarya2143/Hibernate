package OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("OneToMany.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestion("what is java?");

        Answer a1 = new Answer();
        a1.setAnswers("java is programming language");
        a1.setQuestion(q1);

        Answer a2 = new Answer();
        a2.setAnswers("java is object oriented programming language");
        a2.setQuestion(q1);

        Answer a3 = new Answer();
        a3.setAnswers("Java is use to develop softwares.");
        a3.setQuestion(q1);

        Question q2 = new Question();
        q2.setQuestion("Types of inheritance ?");

        Answer a4 = new Answer();
        a4.setAnswers("Single level");
        a4.setQuestion(q2);

        Answer a5 = new Answer();
        a5.setAnswers("Multi Level");
        a5.setQuestion(q2);

        Answer a6 = new Answer();
        a6.setAnswers("Hibrid");
        a6.setQuestion(q2);

        Answer a7 = new Answer();
        a7.setAnswers("Hierarchical");
        a7.setQuestion(q2);

        List<Answer> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswers(list);

        List<Answer> list1 = new ArrayList<>();
        list1.add(a4);
        list1.add(a5);
        list1.add(a6);
        list1.add(a7);

        q2.setAnswers(list1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);  // use persist method because save is depricated
        session.save(a1);
        session.save(a2);
        session.save(a3);
        session.save(q2);
        session.save(a4);
        session.save(a5);
        session.save(a6);
        session.save(a7);

        tx.commit();

        session.close();
        factory.close();

    }
}
