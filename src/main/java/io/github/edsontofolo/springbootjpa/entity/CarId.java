package io.github.edsontofolo.springbootjpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class CarId implements Serializable {
    private Integer brand;
    private Integer id;
}
