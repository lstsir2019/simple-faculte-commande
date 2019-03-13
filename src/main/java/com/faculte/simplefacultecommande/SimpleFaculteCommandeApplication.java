package com.faculte.simplefacultecommande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.faculte.simplefacultecommande.domain.rest")
public class SimpleFaculteCommandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFaculteCommandeApplication.class, args);
	}

}
