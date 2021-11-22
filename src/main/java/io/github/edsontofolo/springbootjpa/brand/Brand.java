package io.github.edsontofolo.springbootjpa.brand;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;

    public Brand(String name) {
        this.name = name;
    }
}
