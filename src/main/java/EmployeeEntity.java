/**
 * Created by Roman on 04.10.2017.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    private int id;
    private String firstName;
    private String lastName;

    private Set<CompanyEntity> cars = new HashSet<CompanyEntity>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_company",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    public Set<CompanyEntity> getCars () {
        return cars;
    }

    public void setCars(Set<CompanyEntity> cars) {
        this.cars = cars;
    }

    public void addCar(CompanyEntity car) {
        cars.add(car);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "firstName", nullable = true, insertable = true, updatable = true, length = 200)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "lastName", nullable = true, insertable = true, updatable = true, length = 200)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}