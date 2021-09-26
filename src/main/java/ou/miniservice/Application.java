package ou.miniservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ou.miniservice.models.Organization;
import ou.miniservice.models.Person;
import ou.miniservice.services.OrganizationService;
import ou.miniservice.services.PersonService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        OrganizationService organizationService = new OrganizationService();
        Organization organization = organizationService.findOrganization(1);
        organization.addPerson(new Person("Иван", "1234 56781234"));
        System.out.println(organization);
        organizationService.updateOrganization(organization);
    }

}