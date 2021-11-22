package io.github.edsontofolo.springbootjpa.brand;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public Optional<BrandDto> deleteById(Integer id) {
        return this.brandRepository.findById(id).map(this::delete);
    }

    private BrandDto delete(Brand brand) {
        this.brandRepository.delete(brand);
        return this.toDto(brand);
    }

    private BrandDto toDto(Brand brand) {
        return this.brandMapper.toDto(brand);
    }
}
