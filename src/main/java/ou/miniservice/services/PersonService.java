package ou.miniservice.services;

import ou.miniservice.models.Organization;
import ou.miniservice.models.Person;
import ou.miniservice.repositories.OrganizationRepository;
import ou.miniservice.repositories.PersonRepository;

import java.util.List;

public class PersonService {
    private PersonRepository personRepository = new PersonRepository();

    public PersonService() {
    }

    public Person findPerson(int id) {
        return personRepository.findById(id);
    }

    public void savePerson(Person person) {
        try {
            personRepository.save(person);
        } catch (Exception e)
        {
            System.out.println("Ошибка добавления");
        }
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public void updatePerson(Person person) {
        personRepository.update(person);
    }
}
