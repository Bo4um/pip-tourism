package com.example.tourismapi;

import com.example.tourismapi.models.Tourist;
import com.example.tourismapi.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;

    @Autowired
    public TouristController(TouristService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getTourist(@PathVariable Long id) {
        try {
            Tourist tourist = service.read(id).orElseThrow();
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("There is no tourist with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    List<Tourist> getTourists() {
        return service.readAll();
    }

    @DeleteMapping("/{id}")
    void deleteTourist(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/")
    ResponseEntity<?> createStudent(@RequestBody Tourist tourist) {
        if(tourist.getFullName() == null || tourist.getUserId() == 0 || tourist.getGroupId() == 0) {
            return new ResponseEntity<>("Bad request body!", HttpStatus.BAD_REQUEST);
        }
        service.create(tourist);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/")
    ResponseEntity<?> updateStudent(@RequestBody Tourist tourist) {
        if(tourist.getFullName() == null || tourist.getUserId() == 0 || tourist.getGroupId() == 0) {
            return new ResponseEntity<>("Bad request body!", HttpStatus.BAD_REQUEST);
        }
        Long id = tourist.getTouristId();
        try {
            service.read(id).orElseThrow();
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("There is no tourist with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

}
