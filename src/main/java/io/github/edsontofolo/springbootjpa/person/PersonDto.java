package io.github.edsontofolo.springbootjpa.person;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.edsontofolo.springbootjpa.car.CarDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Integer id;
    @NotEmpty(message = "Name can not be empty")
    private String name;
    private List<CarDto> cars;
}
