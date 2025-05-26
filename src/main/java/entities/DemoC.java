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
        s2.setFatherName("Kumar");
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

        Student s3 = new Student();
        s3.setName("Nikhil");
        s3.setFatherName("Kirlos");
        s3.setPhone("9964863856");
        s3.setCollege("Vishwakarma institute of technology");
        s3.setActive(true);
        s3.setAbout("Very brave");

        Certificate c3 = new Certificate();
        c3.setTitle("Certificate in Anchoring");
        c3.setLink("http://org.nikhil.in");
        c3.setAbout("Congrats Nikhil!!");

        s3.setCertificate(c3);
        c3.setStudent(s3);

        Student s4 = new Student();
        s4.setName("Karem");
        s4.setFatherName("Saiyad");
        s4.setCollege("COEP");
        s4.setPhone("6789839039");
        s4.setActive(true);
        s4.setAbout("very good student in sports");

        Certificate c4 = new Certificate();
        c4.setTitle("Certified in Dancing");
        c4.setLink("http://org.karem.in");
        c4.setAbout("Congrats Karem!!");

        s4.setCertificate(c4);
        c4.setStudent(s4);

        Student s5 = new Student();
        s5.setName("Arman");
        s5.setFatherName("Shaikh");
        s5.setCollege("JSPM College");
        s5.setPhone("9373894903");
        s5.setActive(true);
        s5.setAbout("very good student in dancing");

        Certificate c5 = new Certificate();
        c5.setTitle("Certified in Dancing");
        c5.setLink("http://org.arman.in");
        c5.setAbout("Congrats arman!!");

        s5.setCertificate(c5);
        c5.setStudent(s5);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(s4);
        session.save(s2);
        session.save(c4);
        session.save(c3);
        session.persist(s3);
        session.persist(c3);
        session.persist(s4);
        session.persist(c4);
        session.persist(s5);
        session.persist(c5);

        tx.commit();

        session.close();
        factory.close();
    }
}
