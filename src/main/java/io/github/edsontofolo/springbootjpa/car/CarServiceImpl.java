package io.github.edsontofolo.springbootjpa.car;

import io.github.edsontofolo.springbootjpa.person.PersonRepository;
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
