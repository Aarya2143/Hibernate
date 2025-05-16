package OneToOneExp1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClass {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("OneToOneExp1.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        //Create
        Passenger p1 = new Passenger();
        p1.setName("Aarya");

        Passport v1 = new Passport();
        v1.setCountry("India");

        p1.setPassport(v1);
        v1.setPassenger(p1);

        //Create
        Passenger p2 = new Passenger();
        p2.setName("Nikita");

        Passport v2 = new Passport();
        v2.setCountry("USA");

        p2.setPassport(v2);
        v2.setPassenger(p2);

        //Create
        Passenger p3 = new Passenger();
        p3.setName("विजया");

        Passport v3 = new Passport();
        v3.setCountry("जर्मनी");

        p3.setPassport(v3);
        v3.setPassenger(p3);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(p1);
        session.save(v1);
        session.save(p2);
        session.save(v2);
        session.save(p3);
        session.save(v3);

        tx.commit();

        session.close();

        factory.close();
    }
}
