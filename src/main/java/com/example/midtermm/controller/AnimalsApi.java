package com.example.midtermm.controller;

import com.example.midtermm.dto.AnimalsDto;
import com.example.midtermm.service.AnimalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animals")
@RequiredArgsConstructor
public class AnimalsApi {
    private final AnimalsService animalsService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(animalsService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(animalsService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addAnimals(@RequestBody AnimalsDto animalsDto){
        animalsService.addAnimals(animalsDto);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnimals(@PathVariable(name = "id") Long id,@RequestBody AnimalsDto animalsDto){
        animalsService.updateAnimals(id,animalsDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimals(@PathVariable(name = "id") Long id){
        animalsService.deleteAnimals(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
