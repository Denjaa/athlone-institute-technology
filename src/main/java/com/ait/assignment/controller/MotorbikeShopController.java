package com.ait.assignment.controller;

import com.ait.assignment.entity.MotorbikeShop;
import com.ait.assignment.repository.MotorbikeShopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class MotorbikeShopController {
    private final MotorbikeShopRepository MotorbikeShopRepository;

    public MotorbikeShopController(MotorbikeShopRepository MotorbikeShopRepository) {
        this.MotorbikeShopRepository = MotorbikeShopRepository;
    }

    @GetMapping(value = "/motorbike", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<MotorbikeShop> getRides() {
        return MotorbikeShopRepository.findAll();
    }

    @GetMapping(value = "/motorbike/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MotorbikeShop getRide(@PathVariable long id) {
        return MotorbikeShopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/motorbike", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MotorbikeShop createRide(@Valid @RequestBody MotorbikeShop themeParkRide) {
        return MotorbikeShopRepository.save(themeParkRide);
    }
}