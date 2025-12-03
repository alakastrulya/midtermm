package com.example.midtermm.controller;

import com.example.midtermm.dto.CompanyDto;
import com.example.midtermm.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyApi {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(companyService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(companyService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody CompanyDto companyDto){
        companyService.addCompany(companyDto);
        return new ResponseEntity<>( HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable(name = "id") Long id,@RequestBody CompanyDto companyDto){
        companyService.updateCompany(id,companyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(name = "id") Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


