package validations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FuncMain {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("validations.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        ValidationsDemo demo = new ValidationsDemo();
        demo.setName("Aarya");
        demo.setNumber("9373111327");
        demo.setBirthadate("21042003");
        demo.setEmail("jadhvaarya9@gmail.com");

        ValidationsDemo demo1 = new ValidationsDemo();
        demo1.setName("Pratik");
        demo1.setNumber("9764537299");
        demo1.setBirthadate("06052001");
        demo1.setEmail("kalepratik9@gmail.com");

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(demo);
        session.persist(demo1);

        ValidatorUtil.validateEntity(demo);
        ValidatorUtil.validateEntity(demo1);


        tx.commit();
        session.close();
        factory.close();
    }
}
