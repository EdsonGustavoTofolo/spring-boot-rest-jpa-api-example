package io.github.edsontofolo.springbootjpa.person;

import io.github.edsontofolo.springbootjpa.car.Car;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Car> cars;

    public Person(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
        this.cars.forEach(car -> car.setPerson(this));
    }

    public void removeCar(Car car) {
        car.setPerson(null);
        this.cars.remove(car);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
