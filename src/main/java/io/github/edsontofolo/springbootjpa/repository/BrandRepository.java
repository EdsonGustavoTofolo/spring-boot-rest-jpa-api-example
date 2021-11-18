package io.github.edsontofolo.springbootjpa.repository;

import io.github.edsontofolo.springbootjpa.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
