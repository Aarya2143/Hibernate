package hql;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session s = factory.openSession();

        System.out.println("=============================== Fetch All Records ========================================");

        String query = "from Student";
        Query q = s.createQuery(query);

        List<Student> list = q.list();

        for(Student stud: list){
            System.out.println(stud.getName());
        }

        Transaction tx = s.beginTransaction();

        /*System.out.println("====================================  Delete Query ========================================");

        Query q2 = s.createQuery("delete from Student where name = :c");
        q2.setParameter("c","Vaibhav");
        int c = q2.executeUpdate();

        System.out.println("deleted name is :"+ c);*/

        System.out.println(" =================================== Update Query =========================================");
        Query q3 = s.createQuery("Update Student set fatherName = :v where name =:a");
        q3.setParameter("v","Giridher");
        q3.setParameter("a","Vaibhav");
        int result = q3.executeUpdate();

        System.out.println("Updated No of result is:"+result);

        tx.commit();
        s.close();
        factory.close();
    }
}
