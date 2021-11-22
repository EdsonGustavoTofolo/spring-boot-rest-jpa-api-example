package io.github.edsontofolo.springbootjpa.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private Integer personId;
    private Integer id;
    @NotEmpty(message = "Name can not be empty")
    private String name;
    @NotNull(message = "Brand can not be null")
    private Integer brandId;
}
