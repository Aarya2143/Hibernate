package Casecading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MainCasecade {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("Casecading.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Question qu1 = new Question();
        qu1.setQuestionId(1);
        qu1.setQuestion("What is multithreading?");

        Answer an1 =new Answer();
        an1.setAnswerId(21);
        an1.setAnswer("Answer1");

        Answer an2 =new Answer();
        an2.setAnswerId(22);
        an2.setAnswer("Answer2");

        Answer an3 =new Answer();
        an3.setAnswerId(23);
        an3.setAnswer("Answer3");

        List<Answer> anslist = new ArrayList<>();
        anslist.add(an1);
        anslist.add(an2);
        anslist.add(an3);

       qu1.setAns(anslist);
       an1.setQue(qu1);
       an2.setQue(qu1);
       an3.setQue(qu1);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.persist(qu1);
        s.persist(an1);
        s.persist(an2);
        s.persist(an3);

        tx.commit();
        s.close();
        factory.close();
    }
}
