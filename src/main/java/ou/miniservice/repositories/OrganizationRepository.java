package ou.miniservice.repositories;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ou.miniservice.models.Organization;
import ou.miniservice.Utils.HibernateSessionFactoryUtil;
import java.util.List;

public class OrganizationRepository {

    public Organization findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Organization.class, id);
    }

    public void save(Organization organization) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        } catch (HibernateException he) {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        }
        Transaction tx1 = session.beginTransaction();
        session.save(organization);
        tx1.commit();
        session.close();
    }

    public void update(Organization organization) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(organization);
        tx1.commit();
        session.close();
    }

    public void delete(Organization organization) {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        }
        Transaction tx1 = session.beginTransaction();
        session.delete(organization);
        tx1.commit();
        session.close();
    }

    public List<Organization> findAll() {
        List<Organization> organizations = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("FROM Organization", Organization.class).list();
        return organizations;
    }
}
