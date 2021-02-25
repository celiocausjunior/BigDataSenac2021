package com.example.cassandra.springbootcassandrademo.controller;


import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<CovidCidades> findById(@PathVariable("id") UUID covidCidadesId){
        CovidCidades covidCidades=covidCidadesRepository.findById(covidCidadesId).orElseThrow(
                () -> new ResouceNotFoundException("Entity not found" + covidCidadesId));
        return ResponseEntity.ok().body(covidCidades);
    }
    
    
    @GetMapping("/covid19/estado/{estado}")
    public ResponseEntity<List<CovidCidades>> findByEstado(@PathVariable("estado") String estadoUf){
        List <CovidCidades> covidEstado=covidCidadesRepository.findByEstado(estadoUf);
        return ResponseEntity.ok().body(covidEstado);
    }


    @GetMapping("/covid19")
    public List<CovidCidades> getAll(){

        return covidCidadesRepository.findAll();
    }

 
    @DeleteMapping("covid19/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") UUID covidCidadesId) {
        CovidCidades covidCidades = covidCidadesRepository.findById(covidCidadesId).orElseThrow(
                () -> new ResouceNotFoundException("Entity not found::: " + covidCidadesId));
        covidCidadesRepository.delete(covidCidades);
        return ResponseEntity.ok().build();
    }

}


