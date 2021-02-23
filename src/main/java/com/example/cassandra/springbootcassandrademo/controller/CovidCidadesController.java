package com.example.cassandra.springbootcassandrademo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cassandra.springbootcassandrademo.ResouceNotFoundException;
import com.example.cassandra.springbootcassandrademo.model.CovidCidades;
import com.example.cassandra.springbootcassandrademo.repository.CovidCidadesRepository;

@RestController
@RequestMapping("/api")
public class CovidCidadesController {

    @Autowired
    CovidCidadesRepository covidCidadesRepository;

    @PostMapping("/covid19")
    public CovidCidades covidCidades(@RequestBody CovidCidades covidCidades){
        covidCidadesRepository.save(covidCidades);
        return covidCidades;

    }

    @GetMapping("/covid19/{id}")
    public ResponseEntity<CovidCidades> findById(@PathVariable("id") Integer productId){
        CovidCidades covidCidades=covidCidadesRepository.findById(productId).orElseThrow(
                () -> new ResouceNotFoundException("Entity not found" + productId));
        return ResponseEntity.ok().body(covidCidades);
    }


    @GetMapping("/covid19")
    public List<CovidCidades> getAll(){

        return covidCidadesRepository.findAll();
    }

 
    @DeleteMapping("covid19/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
        CovidCidades covidCidades = covidCidadesRepository.findById(productId).orElseThrow(
                () -> new ResouceNotFoundException("Product not found::: " + productId));
        covidCidadesRepository.delete(covidCidades);
        return ResponseEntity.ok().build();
    }

}


