package io.github.edsontofolo.springbootjpa.mapper;

import io.github.edsontofolo.springbootjpa.dto.PersonDto;
import io.github.edsontofolo.springbootjpa.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CarMapper.class})
public interface PersonMapper {

    PersonDto toDto(Person person);
    Person toModel(PersonDto personDto);

    @Mapping(source = "cars", target = "cars", ignore = true)
    PersonDto toDtoNoCars(Person person);
}
