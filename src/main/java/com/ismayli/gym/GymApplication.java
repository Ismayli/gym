package com.ismayli.gym;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ismayli.gym.model.Clients;
import com.ismayli.gym.repositories.GymRepository;

@SpringBootApplication
public class GymApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}
	
	@Autowired
	private GymRepository gym;
	
	@Override
	public void run(String... args) throws Exception {

		Clients c1 = new Clients(1, "Luana", "10-10-98", "pswdtest1", "lulu@email.com");
		Clients c2 = new Clients(2, "Bruna", "08-05-86", "pswdtest2", "bruhna@email.com");
		Clients c3 = new Clients(3, "Camila", "15-08-94", "pswdtest3", "CamilaBS@email.com");
		Clients c4 = new Clients(4, "Letícia", "12-11-99", "pswdtest4", "leticiaFB@email.com");
		Clients c5 = new Clients(5, "Paula", "5-5-69", "pswdtest5", "paulinha20@email.com");
		Clients c6 = new Clients(6, "Fernanda", "04-11-10", "pswdtest6", "fefa@email.com");
		Clients c7 = new Clients(7, "Iara", "17-01-05", "pswdtest7", "iaraB@email.com");
		
		gym.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
	}
}