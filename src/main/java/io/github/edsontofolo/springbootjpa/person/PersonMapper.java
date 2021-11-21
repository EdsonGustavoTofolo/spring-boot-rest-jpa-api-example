package io.github.edsontofolo.springbootjpa.person;

import io.github.edsontofolo.springbootjpa.car.CarMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CarMapper.class})
public interface PersonMapper {

    PersonDto toDto(Person person);
    Person toModel(PersonDto personDto);

    @Mapping(source = "cars", target = "cars", ignore = true)
    PersonDto toDtoNoCars(Person person);
}
