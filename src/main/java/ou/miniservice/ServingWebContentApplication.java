package ou.miniservice;

import ou.miniservice.models.Organization;
import ou.miniservice.models.Person;
import ou.miniservice.service.OrganizationService;

public class ServingWebContentApplication {

    public static void main(String[] args) {
        OrganizationService organizationService = new OrganizationService();
        Organization organization = new Organization("Организация1");
        Organization organization1 = new Organization("Организация2");
        Organization organization2 = new Organization("Организация3");
        Person person = new Person("Иван", "1234 567890", organization);
        organization2.addPerson(person);
        organizationService.saveOrganization(organization2);
    }

}