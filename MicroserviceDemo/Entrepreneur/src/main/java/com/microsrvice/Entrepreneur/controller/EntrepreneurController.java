package com.microsrvice.Entrepreneur.controller;

import com.microsrvice.Entrepreneur.dto.EntrepreneureDto;
import com.microsrvice.Entrepreneur.entity.Entrepreneure;
import com.microsrvice.Entrepreneur.service.EntrepreneureService;
import com.microsrvice.Entrepreneur.service.impl.EntrepreneurServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EntrepreneurController {
    @Autowired
    private EntrepreneureService entrepreneureService;

    @PostMapping("/add")
    public ResponseEntity<EntrepreneureDto> create(@RequestBody Entrepreneure entrepreneure)
    {
      EntrepreneureDto entrepreneureDto= entrepreneureService.createEntrepreneur(entrepreneure);
      return new ResponseEntity<>(entrepreneureDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EntrepreneureDto> getEntrepreneur(@PathVariable Long id)
    {
        EntrepreneureDto entrepreneureDto= entrepreneureService.getEntrepreneur(id);
        return new ResponseEntity<>(entrepreneureDto,HttpStatus.OK);
    }

}
