package io.github.edsontofolo.springbootjpa.service;

import io.github.edsontofolo.springbootjpa.entity.ComplementoAnuario;
import io.github.edsontofolo.springbootjpa.mapper.ComplementoAnuarioMapper;
import io.github.edsontofolo.springbootjpa.repository.ComplementoAnuarioRepository;
import io.github.edsontofolo.springbootjpa.dto.ComplementoAnuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ComplementoAnuarioService {

    private final ComplementoAnuarioRepository complementoAnuarioRepository;
    private final ComplementoAnuarioMapper mapper;

    public List<ComplementoAnuarioDto> getAll() {
        List<ComplementoAnuario> all = this.complementoAnuarioRepository.findAll();
        return all.stream().map(this::toDtoNoChilds).collect(Collectors.toList());
    }

    public Optional<ComplementoAnuarioDto> findById(Integer id) {
        return this.complementoAnuarioRepository.findById(id).map(this::toDto);
    }

    public ComplementoAnuarioDto create(ComplementoAnuarioDto complementoAnuarioDto) {
        ComplementoAnuario complementoAnuario = this.toModel(complementoAnuarioDto);
        complementoAnuario.getComplementoAnuarioRamoUrls().forEach(complementoAnuarioRamoUrl -> complementoAnuarioRamoUrl.setComplementoAnuario(complementoAnuario));
        ComplementoAnuario complementoAnuarioCreated = this.complementoAnuarioRepository.save(complementoAnuario);
        return toDto(complementoAnuarioCreated);
    }

    public Optional<ComplementoAnuarioDto> update(ComplementoAnuarioDto complementoAnuarioDto, Integer id) {
        return this.complementoAnuarioRepository.findById(id).map(complementoAnuarioFound -> {
            complementoAnuarioFound.setUrl(complementoAnuarioDto.getUrl());
            complementoAnuarioFound.setTexto(complementoAnuarioDto.getTexto());
            ComplementoAnuario complementoAnuarioUpdated = this.complementoAnuarioRepository.save(complementoAnuarioFound);
            return this.toDto(complementoAnuarioUpdated);
        });
    }

    public Optional<ComplementoAnuarioDto> deleteById(Integer id) {
        return this.complementoAnuarioRepository.findById(id).map(complementoAnuario -> {
           this.complementoAnuarioRepository.delete(complementoAnuario);
           return toDto(complementoAnuario);
        });
    }

    private ComplementoAnuarioDto toDto(ComplementoAnuario complementoAnuario) {
        return this.mapper.toDto(complementoAnuario);
    }

    private ComplementoAnuario toModel(ComplementoAnuarioDto complementoAnuarioDto) {
        return this.mapper.toModel(complementoAnuarioDto);
    }

    private ComplementoAnuarioDto toDtoNoChilds(ComplementoAnuario complementoAnuario) {
        return this.mapper.toDtoNoChilds(complementoAnuario);
    }
}
