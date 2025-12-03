package com.example.midtermm.controller;

import com.example.midtermm.dto.SponsorDto;
import com.example.midtermm.service.SponsorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sponsor")
@RequiredArgsConstructor
public class SponsorApi {
    private final SponsorService sponsorService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(sponsorService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(sponsorService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addSponsor(@RequestBody SponsorDto sponsorDto){
        sponsorService.addSponsor(sponsorDto);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSponsor(@PathVariable(name = "id") Long id,@RequestBody SponsorDto sponsorDto){
        sponsorService.updateSponsor(id,sponsorDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSponsor(@PathVariable(name = "id") Long id){
        if ( sponsorService.deleteSponsor(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
