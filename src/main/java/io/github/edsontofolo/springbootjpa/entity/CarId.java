package io.github.edsontofolo.springbootjpa.entity;

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
