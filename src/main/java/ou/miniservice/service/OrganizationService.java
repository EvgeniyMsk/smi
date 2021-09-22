package ou.miniservice.service;


import org.mariadb.jdbc.internal.util.exceptions.MariaDbSqlException;
import ou.miniservice.models.Organization;
import ou.miniservice.models.Person;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class OrganizationService {

    private OrganizationDao organizationDao = new OrganizationDao();

    public OrganizationService() {
    }

    public Organization findOrganization(int id) {
        return organizationDao.findById(id);
    }

    public void saveOrganization(Organization organization) {
        try {
            organizationDao.save(organization);
        } catch (Exception e)
        {
            System.out.println("Ошибка добавления");
        }
    }

    public void deleteOrganization(Organization organization) {
        organizationDao.delete(organization);
    }

    public void updateOrganization(Organization organization) {
        organizationDao.update(organization);
    }

}