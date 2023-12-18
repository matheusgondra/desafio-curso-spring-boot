package br.com.matheus.springdesafio.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.matheus.springdesafio.models.Data;
import br.com.matheus.springdesafio.models.Models;
import br.com.matheus.springdesafio.models.Vehicle;
import br.com.matheus.springdesafio.services.ApiClient;
import br.com.matheus.springdesafio.services.DataConversor;

public class Menu {
	private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

	private Scanner scan = new Scanner(System.in);
	private ApiClient client = new ApiClient();
	private DataConversor conversor = new DataConversor();

	public void showMenu() {
		String vehicle = null;
		Integer option = null;
		
		System.out.print("""
				**** OPÇÔES ****

				1 - Carro
				2 - Moto
				3 - Caminhão

				Digite uma das opções para consultar os valores:
				""");

		try {
			option = scan.nextInt();
	
			switch (option) {
				case 1:
					vehicle = "carros";
					break;
				case 2:
					vehicle = "motos";
					break;
				case 3:
					vehicle = "caminhoes";
					break;
			}
		} catch (InputMismatchException e) {
			throw new RuntimeException("Invalid option!");
		}

		String json = client.get(BASE_URL + vehicle + "/marcas");
		List<Data> dataBrand = conversor.toList(json, Data.class);
		Collections.sort(dataBrand, (d1, d2) -> Integer.parseInt(d1.code()) - Integer.parseInt(d2.code()));

		dataBrand.forEach(System.out::println);

		System.out.println("Informe o código do modelo para consultar valores:");
		Integer modelCode = scan.nextInt();
		scan.nextLine();

		json = client.get(BASE_URL + vehicle + "/marcas/" + modelCode + "/modelos");
		Models dataModel = conversor.toObject(json, Models.class);
		Collections.sort(dataModel.models(), (d1, d2) -> Integer.parseInt(d1.code()) - Integer.parseInt(d2.code()));
		
		dataBrand.forEach(System.out::println);

		System.out.println("Digite um trecho do nome do veículo para consulta: ");
		var input = scan.nextLine();
		System.out.println(input.toLowerCase());

		dataModel.models().stream()
			.filter(d -> d.name().toLowerCase().contains(input.toLowerCase()))
			.forEach(System.out::println);

		System.out.println("Digite o código do modelo para consultar os valores: ");
		Integer code = scan.nextInt();
		scan.nextLine();
		
		json = client.get(BASE_URL + vehicle + "/marcas/" + modelCode + "/modelos/" + code + "/anos");
		List<Data> dataYear = conversor.toList(json, Data.class);

		List<Vehicle> vehicles = new ArrayList<>();
		for (Data data : dataYear) {
			String jsonQuery = client.get(BASE_URL + vehicle + "/marcas/" + modelCode + "/modelos/" + code + "/anos/" + data.code());
			Vehicle newVehicle = conversor.toObject(jsonQuery, Vehicle.class);
			vehicles.add(newVehicle);
		}

		vehicles.forEach(System.out::println);

		scan.close();
	}
}
