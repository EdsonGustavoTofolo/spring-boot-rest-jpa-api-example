package io.github.edsontofolo.springbootjpa.car;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CarId implements Serializable {
    private Integer person;
    private Integer id;
}
