package io.github.edsontofolo.springbootjpa.service;

import io.github.edsontofolo.springbootjpa.dto.CarDto;

import java.util.Optional;

public interface CarService {

    Optional<Optional<CarDto>> deleteById(Integer personId, Integer carId);
}
