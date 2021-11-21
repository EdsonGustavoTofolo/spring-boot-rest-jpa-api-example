package io.github.edsontofolo.springbootjpa.car;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(source = "person.id", target = "personId")
    @Mapping(source = "brand.id", target = "brandId")
    CarDto toDto(Car car);
    @Mapping(source = "personId", target = "person.id")
    @Mapping(source = "brandId", target = "brand.id")
    Car toModel(CarDto carDto);
}
