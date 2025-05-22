package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DemoC {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Student s1 = new Student();
        s1.setName("Vaibhav");
        s1.setFatherName("Ganesh");
        s1.setCollege("P.E.S. Modern College");
        s1.setPhone("9373111327");
        s1.setActive(true);
        s1.setAbout("very good student in dancing and sports");

        Certificate c1 = new Certificate();
        c1.setTitle("Certified in Dancing");
        c1.setLink("http://org.vaibhav.in");
        c1.setAbout("Congrats vaibhav!!");

        s1.setCertificate(c1);
        c1.setStudent(s1);

        Student s2 = new Student();
        s2.setName("Kalyan");
        s2.setFatherName("Kurashi");
        s2.setCollege("P.E.S. Modern College");
        s2.setPhone("8930023774");
        s2.setActive(true);
        s2.setAbout("very good student in acting");

        Certificate c2 = new Certificate();
        c2.setTitle("Certificate in Sports");
        c2.setLink("http://org.kalyan.in");
        c2.setAbout("Congrats kalyan!!");

        s2.setCertificate(c2);
        c2.setStudent(s2);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(s1);
        session.save(s2);
        session.save(c1);
        session.save(c2);

        tx.commit();

        session.close();
        factory.close();
    }
}
