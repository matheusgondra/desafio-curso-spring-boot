package br.com.matheus.springdesafio.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConversor {
	private ObjectMapper mapper = new ObjectMapper();

	public <T> T toObject(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public <T> List<T> toList(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
