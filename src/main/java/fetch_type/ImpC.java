package fetch_type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ImpC
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("fetchtype.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Question Que1 = new Question();
        Que1.setQuestionId(121);
        Que1.setQuestion("What is Java");

        Answers Ans1 = new Answers();
        Ans1.setAnswerId(1);
        Ans1.setAnswer("Java is programming language");

        Answers Ans2 = new Answers();
        Ans2.setAnswerId(2);
        Ans2.setAnswer("High level object oriented programming language");

        Que1.getAns().add(Ans1);
        Que1.getAns().add(Ans2);
        Ans1.setQue(Que1);
        Ans2.setQue(Que1);

        Question Que2 = new Question();
        Que2.setQuestionId(122);
        Que2.setQuestion("What is python");

        Answers Ans3 =new Answers();
        Ans3.setAnswerId(3);
        Ans3.setAnswer("Python use with AI");

        Answers Ans4 = new Answers();
        Ans4.setAnswerId(4);
        Ans4.setAnswer("Python use with DA");

        Que2.getAns().add(Ans3);
        Que2.getAns().add(Ans4);
        Ans3.setQue(Que2);
        Ans4.setQue(Que2);

        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();

        ses.persist(Que1);
        ses.persist(Ans1);
        ses.persist(Ans2);
        ses.persist(Que2);
        ses.persist(Ans3);
        ses.persist(Ans4);

        Question q =(Question) ses.get(Question.class, 122);

        System.out.println(q.getQuestionId());
        System.out.println(q.getQuestion());

        /*
        //Lazy Loading
        System.out.println(q.getAns().size());

        //Eager Loading
        In Eager Loading we need to add (fetch = fetchType.EAGER)
         ex ->  @OneToMany(mappedBy = "que", fetch = FetchType.EAGER)
            private List<Answers> ans = new ArrayList<>();
        */

        tx.commit();
        ses.close();
        factory.close();
    }
}
