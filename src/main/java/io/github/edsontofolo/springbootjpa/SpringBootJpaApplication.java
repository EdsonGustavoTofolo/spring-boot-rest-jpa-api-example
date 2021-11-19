package io.github.edsontofolo.springbootjpa;

import io.github.edsontofolo.springbootjpa.entity.Brand;
import io.github.edsontofolo.springbootjpa.entity.Car;
import io.github.edsontofolo.springbootjpa.entity.Person;
import io.github.edsontofolo.springbootjpa.repository.BrandRepository;
import io.github.edsontofolo.springbootjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

            Brand kia = new Brand();
            kia.setName("Kia");

            Brand volkswagen = new Brand();
            volkswagen.setName("Volkswagen");

            brandRepository.saveAll(Arrays.asList(kia, volkswagen));
            System.out.println("Brands saved...");

            System.out.println("Saving people...");

            Car cerato = new Car();
            cerato.setName("Cerato");
            cerato.setBrand(kia);

            Car sportage = new Car();
            sportage.setName("Sportage");
            sportage.setBrand(kia);

            Car golf = new Car();
            golf.setName("Golf");
            golf.setBrand(volkswagen);


            Person jonh = new Person();
            jonh.setName("John");
            jonh.addCar(cerato);
            jonh.addCar(sportage);

            Person donald = new Person();
            donald.setName("Donald");
            donald.addCar(golf);

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
