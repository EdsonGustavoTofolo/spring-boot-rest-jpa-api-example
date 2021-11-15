package io.github.edsontofolo.springbootjpa.mapper;

import io.github.edsontofolo.springbootjpa.dto.ComplementoAnuarioDto;
import io.github.edsontofolo.springbootjpa.entity.ComplementoAnuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComplementoAnuarioMapper {

    ComplementoAnuario toModel(ComplementoAnuarioDto complementoAnuarioDto);

    @Mapping(source = "complementoAnuarioRamoUrls", target = "complementoAnuarioRamoUrls", ignore = true)
    ComplementoAnuarioDto toDtoNoChilds(ComplementoAnuario complementoAnuario);

    ComplementoAnuarioDto toDto(ComplementoAnuario complementoAnuario);
}
