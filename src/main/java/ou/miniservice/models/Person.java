package ou.miniservice.models;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "passport")
    private String passport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizationid")
    private Organization organization;

    public Person() {
    }

    public Person(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public Person(String name, String passport, Organization organization) {
        this.name = name;
        this.passport = passport;
        this.organization = organization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organization=" + organization.getName() +
                '}';
    }
}
