package com.example.test.controllers;

import com.example.test.dto.ResponseDTO;
import com.example.test.entities.ExperienceEntity;
import com.example.test.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping(path = "/experience")
public class ExperienceController {
    @Autowired
    ExperienceRepository experienceRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<ExperienceEntity>> index() {
        List<ExperienceEntity> ls = experienceRepository.findAll();
        if (ls.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(ls);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExperienceEntity> detail(@PathVariable("id") int id) {
        Optional<ExperienceEntity> op = experienceRepository.findById(id);
        if (op.isPresent()) {
            ExperienceEntity experience = op.get();
            return ResponseEntity.ok(experience);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<ExperienceEntity>> find(@RequestParam String value) {
        List<ExperienceEntity> ls = experienceRepository.findByQuery(value);
        if (ls.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(ls);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> save(@Valid @RequestBody ExperienceEntity experience, BindingResult result) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (result.hasErrors()) {
            List<String> lsMsg = new ArrayList<>();
            for (ObjectError err : result.getAllErrors()) {
                String field = ((FieldError) err).getField();
                lsMsg.add(field + ": " + err.getDefaultMessage());
            }
            responseDTO.setStatus("FAIL");
            responseDTO.setObject(lsMsg);
            return ResponseEntity.ok(responseDTO);
        }
        experienceRepository.save(experience);
        responseDTO.setStatus("SUCCESS");
        responseDTO.setObject(experience);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping(value = "")
    public ResponseEntity<ExperienceEntity> delete(@RequestParam(value = "id") int id) {
        Optional<ExperienceEntity> op = experienceRepository.findById(id);
        if (op.isPresent()) {
            experienceRepository.delete(op.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "")
    ResponseEntity<ExperienceEntity> update(
            @RequestParam(value = "id") int id,
            @RequestBody ExperienceEntity experience) {
        Optional<ExperienceEntity> op = experienceRepository.findById(id);
        if (op.isPresent()) {
            experienceRepository.save(experience);
            return ResponseEntity.ok(experience);
        }
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
