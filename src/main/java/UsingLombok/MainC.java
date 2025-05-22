package UsingLombok;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainC {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("Worker.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Worker wor = new Worker();
        wor.setId(1);
        wor.setName("Vaibhav");
        wor.setCompany("congnizant");
        wor.setSalary(80000.00);

        Worker wor2 = new Worker(2,"Shyam","TCS",70000.90);

        Worker wor3 = new Worker(3,"Virendre","infosys",50000.34);

        Worker wor4 = new Worker(4,"Umraj","Oyasis",60000);

        Worker wor5 = new Worker(5,"Shreya","Corizo",450000);

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();

        s.persist(wor);
        s.persist(wor2);
        s.persist(wor3);
        s.persist(wor4);
        s.persist(wor5);

        tx.commit();
        s.close();
        factory.close();
    }
}
