package com.example.cassandra.springbootcassandrademo.repository;

import com.example.cassandra.springbootcassandrademo.model.CovidCidades;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CovidCidadesRepository extends CassandraRepository<CovidCidades,Integer> {
}
