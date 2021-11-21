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
        return this.personRepository.findById(personId)
                .map(person -> this.carRepository
                        .findById(new CarId(personId, carId))
                            .map(car -> {
                               person.removeCar(car);
                               this.personRepository.save(person);
                               return this.toDto(car);
                            }));
    }

    private CarDto toDto(Car car){
        return this.carMapper.toDto(car);
    }
}
