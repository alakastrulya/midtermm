package com.example.midtermm.controller;


import com.example.midtermm.entity.UserModel;
import com.example.midtermm.service.SponsorService;
import com.example.midtermm.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserModelApi {

    private final UserService myUserService;
    private final SponsorService sponsorService;

    @GetMapping
    public String getAll1(){
        return "done";
    }

    @PostMapping("/registr")
    public void registr(@RequestBody UserModel model){
        myUserService.registr(model);
    }

    @GetMapping("/sponsors")
    @PreAuthorize("hasAuthority('ROLE_SPONSOR')")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(sponsorService.getAll(), HttpStatus.OK);
    }

}
