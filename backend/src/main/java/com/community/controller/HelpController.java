package com.community.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.model.HelpRequest;
import com.community.repository.HelpRepository;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin("*")
public class HelpController {

    private final HelpRepository repository;

    public HelpController(HelpRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public HelpRequest create(@RequestBody HelpRequest request) {

        return repository.save(request);
    }

    @GetMapping
    public List<HelpRequest> getAll() {

        return repository.findAll();
    }

    @PutMapping("/{id}")
    public HelpRequest complete(@PathVariable String id) {

        HelpRequest request =
                repository.findById(id).orElseThrow();

        request.setStatus("COMPLETED");

        return repository.save(request);
    }
}