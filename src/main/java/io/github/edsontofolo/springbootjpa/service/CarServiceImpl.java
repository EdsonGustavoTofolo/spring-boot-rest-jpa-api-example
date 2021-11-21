package io.github.edsontofolo.springbootjpa.service;

import io.github.edsontofolo.springbootjpa.dto.CarDto;
import io.github.edsontofolo.springbootjpa.entity.Car;
import io.github.edsontofolo.springbootjpa.entity.CarId;
import io.github.edsontofolo.springbootjpa.mapper.CarMapper;
import io.github.edsontofolo.springbootjpa.repository.CarRepository;
import io.github.edsontofolo.springbootjpa.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;
    private final CarMapper carMapper;

    @Override
    public Optional<Optional<CarDto>> deleteById(Integer personId, Integer carId) {
        if (this.personRepository.existsById(personId)) {
            Optional<CarDto> carDto = this.carRepository.findById(new CarId(personId, carId)).map(car -> {
                this.carRepository.delete(car);
                return this.toDto(car);
            });
            return Optional.of(carDto);
        } else {
            return Optional.empty();
        }
    }

    private CarDto toDto(Car car){
        return this.carMapper.toDto(car);
    }
}
