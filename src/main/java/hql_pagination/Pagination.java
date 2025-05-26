package hql_pagination;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Pagination {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Query query = session.createQuery("from Student");

        //Implementing pagination using hibernate
        query.setFirstResult(0);
        query.setMaxResults(3);
        List<Student> list = query.list();

        for(Student l : list){
            System.out.println(l.getStudentId()+" : "+l.getName());
        }

        session.close();
        factory.close();
    }
}
