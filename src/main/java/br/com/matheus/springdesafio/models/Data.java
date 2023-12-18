package br.com.matheus.springdesafio.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(
	@JsonAlias("codigo") String code,
	@JsonAlias("nome") String name
) {
	public String toString() {
		return "Cód: " + code() + " Descrição: " + name();
	}
}
