package io.github.edsontofolo.springbootjpa.rest;

import io.github.edsontofolo.springbootjpa.dto.PersonDto;
import io.github.edsontofolo.springbootjpa.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonDto personDto) {
        PersonDto personDtoCreated = this.personService.create(personDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(personDtoCreated.getId()).toUri();
        return ResponseEntity.created(location).body(personDtoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Integer id, @RequestBody PersonDto personDto) {
        PersonDto personDtoUpdated = this.personService.update(id, personDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found!"));
        return ResponseEntity.ok(personDtoUpdated);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        List<PersonDto> people = this.personService.getAll();
        return ResponseEntity.ok(people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable Integer id) {
        PersonDto personDto = this.personService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found!"));
        return ResponseEntity.ok(personDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        this.personService.deleteById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found!"));
        return ResponseEntity.noContent().build();
    }
}
