package io.github.edsontofolo.springbootjpa.car;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/people/{personId}/cars")
public class CarRestController {

    private final CarService carService;

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer personId,
                                           @PathVariable Integer carId) {
        this.carService.deleteById(personId, carId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
        return ResponseEntity.noContent().build();
    }
}
