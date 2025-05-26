package firstlevel_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConfigClass {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("firstlevel_cache.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        emp.setEmployeeId(1);
        emp.setName("Birju");
        emp.setSalary(50000.89);

        Employee emp1 = new Employee();
        emp1.setEmployeeId(2);
        emp1.setName("kaivalya");
        emp1.setSalary(80000.9);

        Employee emp2 = new Employee();
        emp2.setEmployeeId(3);
        emp2.setName("Akash");
        emp2.setSalary(45000.00);

        session.persist(emp);
        session.persist(emp1);
        session.persist(emp2);

        tx.commit();

        Employee e1 = session.get(Employee.class, 2);
        System.out.println(e1);

        System.out.println("================= doing some work =======================");

        Employee e2 = session.get(Employee.class, 2);
        System.out.println(e2);

        session.close();
        factory.close();
    }
}
