package io.github.edsontofolo.springbootjpa.person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<PersonDto> getAll();
    Optional<PersonDto> findById(Integer id);
    PersonDto create(PersonDto personDto);
    Optional<PersonDto> update(Integer id, PersonDto personDto);
    Optional<PersonDto> deleteById(Integer id);
}
