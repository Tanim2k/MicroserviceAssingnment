package com.microsrvice.Investor.controller;

import com.microsrvice.Investor.dto.InvestorDto;
import com.microsrvice.Investor.entity.Investor;
import com.microsrvice.Investor.service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invest")
public class InvestorController {

    @Autowired
    private InvestorService entrepreneureService;

    @PostMapping("/add")
    public ResponseEntity<InvestorDto> create(@RequestBody Investor entrepreneure)
    {
        InvestorDto entrepreneureDto= entrepreneureService.createInvestor(entrepreneure);
        return new ResponseEntity<>(entrepreneureDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<InvestorDto> getEntrepreneur(@PathVariable Long id)
    {
        InvestorDto entrepreneureDto= entrepreneureService.getInvestor(id);
        return new ResponseEntity<>(entrepreneureDto,HttpStatus.OK);
    }
}
