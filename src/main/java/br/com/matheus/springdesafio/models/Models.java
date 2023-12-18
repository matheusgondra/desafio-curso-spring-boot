package br.com.matheus.springdesafio.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Models(
	@JsonAlias("modelos") List<Data> models
) {}
