package io.github.edsontofolo.springbootjpa.car;

import io.github.edsontofolo.springbootjpa.brand.Brand;
import io.github.edsontofolo.springbootjpa.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@IdClass(CarId.class)
@SequenceGenerator(name = "GEN_CAR_SEQ", sequenceName = "CAR_ID_SEQUENCE")
public class Car {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person")
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_CAR_SEQ")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand", nullable = false, updatable = false)
    private Brand brand;

    public Car(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "person=" + person +
                ", id=" + id +
                ", name='" + name +
                '}';
    }
}
