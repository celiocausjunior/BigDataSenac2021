package com.example.cassandra.springbootcassandrademo.model;


import java.util.UUID;
import java.util.Date;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table
@Data
public class CovidCidades {

    @PrimaryKey
    private UUID id = UUID.randomUUID();
    
    private String regiao;
    private String estado;
    private String municipio;
    private String coduf;
    private String codmun;
    private Date data;
    private Integer casosAcumulado;
    private Integer casosNovos;
    private Integer obitosAcumulado;
    
    
    public CovidCidades() {}
    
    
	public CovidCidades(UUID id, String regiao, String estado, String municipio, String coduf, String codmun, Date data,
			Integer casosAcumulado, Integer casosNovos, Integer obitosAcumulado) {
		this.id = id;
		this.regiao = regiao;
		this.estado = estado;
		this.municipio = municipio;
		this.coduf = coduf;
		this.codmun = codmun;
		this.data = data;
		this.casosAcumulado = casosAcumulado;
		this.casosNovos = casosNovos;
		this.obitosAcumulado = obitosAcumulado;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCoduf() {
		return coduf;
	}
	public void setCoduf(String coduf) {
		this.coduf = coduf;
	}
	public String getCodmun() {
		return codmun;
	}
	public void setCodmun(String codmun) {
		this.codmun = codmun;
	}

	public Integer getCasosAcumulado() {
		return casosAcumulado;
	}
	public void setCasosAcumulado(Integer casosAcumulado) {
		this.casosAcumulado = casosAcumulado;
	}
	public Integer getCasosNovos() {
		return casosNovos;
	}
	public void setCasosNovos(Integer casosNovos) {
		this.casosNovos = casosNovos;
	}
	public Integer getObitosAcumulado() {
		return obitosAcumulado;
	}
	public void setObitosAcumulado(Integer obitosAcumulado) {
		this.obitosAcumulado = obitosAcumulado;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

    
   
}
