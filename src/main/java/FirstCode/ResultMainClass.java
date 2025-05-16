package FirstCode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ResultMainClass {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("FirstCode.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        SimplePojoClass obj = new SimplePojoClass();
        obj.setName("Aarya");
        obj.setAge(23);
        obj.setPercentage(90.06);

        SimplePojoClass obj1 = new SimplePojoClass();
        obj1.setName("Nikita");
        obj1.setAge(24);
        obj1.setPercentage(93.06);

        SimplePojoClass obj2 = new SimplePojoClass();
        obj2.setName("Aruna");
        obj2.setAge(20);
        obj2.setPercentage(85.00);

        SimplePojoClass obj3 = new SimplePojoClass();
        obj3.setName("Kalyani");
        obj3.setAge(22);
        obj3.setPercentage(79.60);

        SimplePojoClass obj4 = new SimplePojoClass();
        obj4.setName("Sikriti");
        obj4.setAge(23);
        obj4.setPercentage(69.89);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(obj);
        session.save(obj1);
        session.save(obj2);
        session.save(obj3);
        session.save(obj4);

        tx.commit();

        session.close();
        factory.close();
    }
}
