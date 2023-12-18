package br.com.matheus.springdesafio.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Vehicle(
	@JsonAlias("codigo") Integer code,
	@JsonAlias("nome") String name
) {}
