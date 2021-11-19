package io.github.edsontofolo.springbootjpa.repository;

import io.github.edsontofolo.springbootjpa.entity.Car;
import io.github.edsontofolo.springbootjpa.entity.CarId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, CarId> {
}
