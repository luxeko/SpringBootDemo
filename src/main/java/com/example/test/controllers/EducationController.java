package com.example.test.controllers;

import com.example.test.entities.EducationEntity;
import com.example.test.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/education")
public class EducationController {
    @Autowired
    EducationRepository educationRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<EducationEntity>> index() {
        List<EducationEntity> ls = educationRepository.findAll();
        if (ls.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EducationEntity>>(ls, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EducationEntity> detail(@PathVariable("id") int id) {
        Optional<EducationEntity> op = educationRepository.findById(id);
        if (op.isPresent()) {
            EducationEntity education = op.get();
            return new ResponseEntity<EducationEntity>(education, HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<EducationEntity>> find(@RequestParam(name = "value") String value) {
        List<EducationEntity> ls = educationRepository.findByQuery(value);
        if (ls.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EducationEntity>>(ls, HttpStatus.OK);
    }
    @PostMapping(value = "")
    public ResponseEntity<EducationEntity> save(@RequestBody EducationEntity education) {
        educationRepository.save(education);
        return ResponseEntity.ok(education);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<EducationEntity> delete(@RequestParam(value = "id") int id) {
        Optional<EducationEntity> op = educationRepository.findById(id);
        if (op.isPresent()) {
            educationRepository.delete(op.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // truyền param id lên thông qua data
    @PutMapping (value = "")
    ResponseEntity<EducationEntity> update(
            @RequestParam(value = "id") int id,
            @RequestBody EducationEntity education) {
        Optional<EducationEntity> op = educationRepository.findById(id);
        if (op.isPresent()) {
            educationRepository.save(education);
            return ResponseEntity.ok(education);
        }
        return ResponseEntity.notFound().build();
    }

    // truyền param id lên api
//    @PutMapping(value = "")
//    ResponseEntity<EducationEntity> update(@RequestBody EducationEntity education) {
//        Optional<EducationEntity> op = educationRepository.findById(education.getId());
//        if (op.isPresent()) {
//            educationRepository.save(education);
//            return ResponseEntity.ok(education);
//        }
//        return ResponseEntity.notFound().build();
//    }
}
