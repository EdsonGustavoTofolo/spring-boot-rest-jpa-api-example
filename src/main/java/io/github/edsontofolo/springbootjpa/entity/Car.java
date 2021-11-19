package io.github.edsontofolo.springbootjpa.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@IdClass(CarId.class)
@SequenceGenerator(name = "CAR_SEQ", sequenceName = "CAR_ID_SEQUENCE")
public class Car {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_SEQ")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
