package ou.miniservice.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ou.miniservice.models.Organization;
import ou.miniservice.models.Person;

import java.util.List;

public class OrganizationDao {

    public Organization findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Organization.class, id);
    }

    public void save(Organization organization) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(organization);
        tx1.commit();
        session.close();
    }

    public void update(Organization organization) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(organization);
        tx1.commit();
        session.close();
    }

    public void delete(Organization organization) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(organization);
        tx1.commit();
        session.close();
    }

    public List<Organization> findAll() {
        List<Organization> organizations = (List<Organization>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from miniservice.organization").list();
        return organizations;
    }
}
