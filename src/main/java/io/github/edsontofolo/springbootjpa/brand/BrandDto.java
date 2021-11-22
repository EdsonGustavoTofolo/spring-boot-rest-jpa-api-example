package io.github.edsontofolo.springbootjpa.brand;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BrandDto {
    private Integer id;
    @NotEmpty(message = "Name can not be empty")
    private String name;
}
