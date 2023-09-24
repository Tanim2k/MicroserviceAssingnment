package com.microsrvice.ProjectIdea.controller;

import com.microsrvice.ProjectIdea.dto.IdeaAndInvestDto;
import com.microsrvice.ProjectIdea.dto.IdeaDto;
import com.microsrvice.ProjectIdea.entity.Ideas;
import com.microsrvice.ProjectIdea.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/idea")
public class DemoController {
    @Autowired
    private IdeaService entrepreneureService;

    @PostMapping("/add")
    public ResponseEntity<IdeaDto> create(@RequestBody Ideas entrepreneure)
    {
        IdeaDto entrepreneureDto= entrepreneureService.createIdea(entrepreneure);
        return new ResponseEntity<>(entrepreneureDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<IdeaAndInvestDto> getEntrepreneur(@PathVariable Long id)
    {
        IdeaAndInvestDto entrepreneureDto= entrepreneureService.getIdea(id);
        return new ResponseEntity<>(entrepreneureDto,HttpStatus.OK);
    }
}
