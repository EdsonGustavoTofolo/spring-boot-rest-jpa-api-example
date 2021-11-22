package io.github.edsontofolo.springbootjpa.brand;

import java.util.Optional;

public interface BrandService {
    Optional<BrandDto> deleteById(Integer id);
}
