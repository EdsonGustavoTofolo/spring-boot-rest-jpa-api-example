package io.github.edsontofolo.springbootjpa.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Integer id;
    private String name;
    private Integer brandId;
}
