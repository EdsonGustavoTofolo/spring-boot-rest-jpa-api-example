package io.github.edsontofolo.springbootjpa.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public List<PersonDto> getAll() {
        List<Person> people = this.personRepository.findAll();
        return people.stream().map(this::toDtoNoCars).collect(Collectors.toList());
    }

    @Override
    public Optional<PersonDto> findById(Integer id) {
        return this.personRepository.findById(id).map(this::toDto);
    }

    @Override
    public PersonDto create(PersonDto personDto) {
        Person person = this.toModel(personDto);
        if (person.getCars() != null) {
            person.getCars().forEach(car -> car.setPerson(person));
        }
        Person personSaved = this.personRepository.save(person);
        return this.toDto(personSaved);
    }

    @Override
    public Optional<PersonDto> update(Integer id, PersonDto personDto) {
        return this.personRepository.findById(id).map(person -> {
           person.setName(personDto.getName());
            Person personSaved = this.personRepository.save(person);
            return this.toDto(personSaved);
        });
    }

    @Override
    public Optional<PersonDto> deleteById(Integer id) {
        return this.personRepository.findById(id).map(person -> {
            this.personRepository.delete(person);
            return this.toDto(person);
        });
    }

    private PersonDto toDtoNoCars(Person person) {
        return this.personMapper.toDtoNoCars(person);
    }

    private PersonDto toDto(Person person) {
        return this.personMapper.toDto(person);
    }

    private Person toModel(PersonDto personDto) {
        return this.personMapper.toModel(personDto);
    }

}
