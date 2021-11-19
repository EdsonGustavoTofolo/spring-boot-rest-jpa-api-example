package io.github.edsontofolo.springbootjpa.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> cars;

    public void addCar(Car car) {
        if (this.cars == null) {
            this.cars = new ArrayList<>();
        }
        this.cars.add(car);
        car.setPerson(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
