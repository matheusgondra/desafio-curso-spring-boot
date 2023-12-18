package br.com.matheus.springdesafio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.matheus.springdesafio.main.Menu;

@SpringBootApplication
public class SpringDesafioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
		menu.showMenu();
	}
}
