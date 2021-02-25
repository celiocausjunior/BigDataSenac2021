package com.example.cassandra.springbootcassandrademo.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.cassandra.springbootcassandrademo.model.CovidCidades;

public interface CovidCidadesRepository extends CassandraRepository<CovidCidades,Integer> {

	 @AllowFiltering
	public List <CovidCidades> findByEstado(String estado);  
}

