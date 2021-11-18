package io.github.edsontofolo.springbootjpa.service;

import io.github.edsontofolo.springbootjpa.dto.PersonDto;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<PersonDto> getAll();
    Optional<PersonDto> findById(Integer id);
    PersonDto create(PersonDto personDto);
    Optional<PersonDto> update(Integer id, PersonDto personDto);
    Optional<PersonDto> deleteById(Integer id);

}
