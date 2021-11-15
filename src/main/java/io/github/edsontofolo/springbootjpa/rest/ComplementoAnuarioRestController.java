package io.github.edsontofolo.springbootjpa.rest;

import io.github.edsontofolo.springbootjpa.dto.ComplementoAnuarioDto;
import io.github.edsontofolo.springbootjpa.service.ComplementoAnuarioService;
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
@RequestMapping("/api/complementos-anuarios")
public class ComplementoAnuarioRestController {

    private final ComplementoAnuarioService complementoAnuarioService;

    @GetMapping
    public ResponseEntity<List<ComplementoAnuarioDto>> getAll() {
        List<ComplementoAnuarioDto> all = this.complementoAnuarioService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplementoAnuarioDto> getById(@PathVariable Integer id) {
        ComplementoAnuarioDto complemento = this.complementoAnuarioService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Complemento not found"));
        return ResponseEntity.ok(complemento);
    }

    @PostMapping
    public ResponseEntity<ComplementoAnuarioDto> create(@RequestBody ComplementoAnuarioDto complementoAnuarioDto) {
        ComplementoAnuarioDto complementoAnuarioCreated = this.complementoAnuarioService.create(complementoAnuarioDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(complementoAnuarioCreated.getId()).toUri();
        return ResponseEntity.created(location).body(complementoAnuarioCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComplementoAnuarioDto> update(@RequestBody ComplementoAnuarioDto complementoAnuarioDto, @PathVariable Integer id) {
        ComplementoAnuarioDto complemento = this.complementoAnuarioService.update(complementoAnuarioDto, id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Complemento not found"));
        return ResponseEntity.ok(complemento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        this.complementoAnuarioService.deleteById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Complemento not found"));
        return ResponseEntity.noContent().build();
    }
}
