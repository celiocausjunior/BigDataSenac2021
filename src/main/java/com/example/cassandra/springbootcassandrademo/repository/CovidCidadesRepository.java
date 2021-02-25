package com.example.cassandra.springbootcassandrademo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.cassandra.springbootcassandrademo.model.CovidCidades;

public interface CovidCidadesRepository extends CassandraRepository<CovidCidades,UUID> {

	 @AllowFiltering
	public List <CovidCidades> findByEstado(String estado);  
}

