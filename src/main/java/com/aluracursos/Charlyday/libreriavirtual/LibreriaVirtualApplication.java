package com.aluracursos.Charlyday.libreriavirtual;

import com.aluracursos.Charlyday.libreriavirtual.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaVirtualApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaVirtualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
