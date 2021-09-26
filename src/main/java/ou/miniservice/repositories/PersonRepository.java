package ou.miniservice.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ou.miniservice.Utils.HibernateSessionFactoryUtil;
import ou.miniservice.models.Person;
import java.util.List;

public class PersonRepository {
    public Person findById(int id) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException he) {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        }

        return session.get(Person.class, id);
    }

    public void save(Person person) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException he) {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        }
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        }
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }

    public List<Person> findAll() {
        List<Person> personList = (List<Person>)  HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Person").list();
        return personList;
    }
}
