package br.com.matheus.springdesafio.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.matheus.springdesafio.services.ApiClient;

public class Menu {
	Scanner scan = new Scanner(System.in);
	ApiClient client = new ApiClient();

	public void showMenu() {
		System.out.println("**** OPÇÔES ****");
		System.out.println("1 - Carro\n2 - Moto\n3 - Caminhão");
		System.out.print("Digite uma das opções para consultar os valores: ");
		String vehicle = null;

		try {
			Integer option = scan.nextInt();
	
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
			throw new InputMismatchException("Invalid option!");
		}

		String url = "https://parallelum.com.br/fipe/api/v1/";
		String json = client.get(url + vehicle + "/marcas");
		System.out.println(json);

	}
}
