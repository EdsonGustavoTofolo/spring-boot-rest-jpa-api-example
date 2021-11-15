package io.github.edsontofolo.springbootjpa.repository;

import io.github.edsontofolo.springbootjpa.entity.ComplementoAnuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplementoAnuarioRepository extends JpaRepository<ComplementoAnuario, Integer> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = {"complementoAnuarioRamoUrls"})
    @Override
    Optional<ComplementoAnuario> findById(Integer integer);
}
