package xml_based;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Testing {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("Person.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Person p1 = new Person();
        p1.setName("Aarya");
        p1.setLastname("Jadhav");
        p1.setAge(22);

        Person p2 = new Person();
        p2.setName("Nikhil");
        p2.setLastname("Biradar");
        p2.setAge(24);

        Person p3 = new Person();
        p3.setName("Nikita");
        p3.setLastname("Kadam");
        p3.setAge(23);

        Person p4 = new Person();
        p4.setName("Bhagyashree");
        p4.setLastname("shinde");
        p4.setAge(25);

        Person p5 = new Person();
        p5.setName("Vivek");
        p5.setLastname("Patil");
        p5.setAge(25);

        Person p6 = new Person();
        p6.setName("Megha");
        p6.setLastname("Biradar");
        p6.setAge(26);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.save(p1);
        s.save(p2);
        s.save(p3);
        s.save(p4);
        s.save(p5);
        s.save(p6);

        tx.commit();
        s.close();

        factory.close();
    }
}
