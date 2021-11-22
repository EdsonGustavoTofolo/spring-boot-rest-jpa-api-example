package io.github.edsontofolo.springbootjpa.brand;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDto toDto(Brand brand);
}
