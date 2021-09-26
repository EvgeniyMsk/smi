package ou.miniservice.services;


import ou.miniservice.models.Organization;
import ou.miniservice.repositories.OrganizationRepository;

import java.util.List;

public class OrganizationService {

    private OrganizationRepository organizationRepository = new OrganizationRepository();

    public OrganizationService() {
    }

    public Organization findOrganization(int id) {
        return organizationRepository.findById(id);
    }

    public void saveOrganization(Organization organization) {
        try {
            organizationRepository.save(organization);
        } catch (Exception e)
        {
            System.out.println("Ошибка добавления");
        }
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public void deleteOrganization(Organization organization) {
        organizationRepository.delete(organization);
    }

    public void updateOrganization(Organization organization) {
        organizationRepository.update(organization);
    }

}