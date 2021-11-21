package io.github.edsontofolo.springbootjpa.car;

import java.util.Optional;

public interface CarService {

    Optional<Optional<CarDto>> deleteById(Integer personId, Integer carId);
}
