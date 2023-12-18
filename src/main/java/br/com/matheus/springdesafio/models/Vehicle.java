package br.com.matheus.springdesafio.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle(
	@JsonAlias("Valor") String value,
	@JsonAlias("Marca") String brand,
	@JsonAlias("Modelo") String model,
	@JsonAlias("AnoModelo") String year,
	@JsonAlias("Combustivel") String fuel,
	@JsonAlias("CodigoFipe") String fipeCode,
	@JsonAlias("MesReferencia") String referenceMonth
) {}
