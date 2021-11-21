package io.github.edsontofolo.springbootjpa;

import io.github.edsontofolo.springbootjpa.brand.Brand;
import io.github.edsontofolo.springbootjpa.car.Car;
import io.github.edsontofolo.springbootjpa.person.Person;
import io.github.edsontofolo.springbootjpa.brand.BrandRepository;
import io.github.edsontofolo.springbootjpa.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired PersonRepository personRepository,
                                  @Autowired BrandRepository brandRepository){
        return args -> {
            System.out.println("Saving brands...");

            Brand kia = new Brand("Kia");

            Brand volkswagen = new Brand("Volkswagen");

            brandRepository.saveAll(Arrays.asList(kia, volkswagen));
            System.out.println("Brands saved...");

            System.out.println("Saving people...");

            Car cerato = new Car("Cerato", kia);

            Car sportage = new Car("Sportage", kia);

            Car golf = new Car("Golf", volkswagen);

            Car nivus = new Car("Nivus", volkswagen);

            Person jonh = new Person("John", Arrays.asList(cerato, sportage, nivus));

            Person donald = new Person("Donald", Arrays.asList(golf));

            personRepository.save(jonh);
            personRepository.save(donald);
            System.out.println("People saved...");

            List<Person> people = personRepository.findAll();
            people.forEach(System.out::println);

            people.forEach(person -> {
                personRepository.findById(person.getId()).map(person1 -> {
                    person1.getCars().forEach(System.out::println);
                    return person1;
                }).orElseThrow(() -> new IllegalArgumentException("Person not found"));
            });
        };
    }
}
