package io.github.edsontofolo.springbootjpa.car;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(source = "brand.id", target = "brandId")
    CarDto toDto(Car car);
    @Mapping(source = "brandId", target = "brand.id")
    Car toModel(CarDto carDto);
}
