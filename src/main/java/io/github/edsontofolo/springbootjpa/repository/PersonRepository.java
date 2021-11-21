package io.github.edsontofolo.springbootjpa.repository;

import io.github.edsontofolo.springbootjpa.entity.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"cars"})
    @Override
    Optional<Person> findById(Integer id);
}
