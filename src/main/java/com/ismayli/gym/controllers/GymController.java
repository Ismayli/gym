package com.ismayli.gym.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismayli.gym.model.Clients;
import com.ismayli.gym.service.GymService;

@RestController
@RequestMapping("/clients")
public class GymController {

	@Autowired
	private GymService gymservice;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Clients> findById(@PathVariable int id) {
		Clients client = gymservice.findById(id);
		return ResponseEntity.ok().body(client);
	}

	@GetMapping
	public ResponseEntity<List<Clients>> findAll() {
		List<Clients> clientsList = gymservice.findAll();
		return ResponseEntity.ok().body(clientsList);
	}

	@PostMapping
	public ResponseEntity<Clients> created(@RequestBody Clients clients) {
		clients = (Clients) gymservice.save(clients);
		return ResponseEntity.ok().body(clients);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Clients> update(@RequestBody Clients clients, @PathVariable int id) {
		Clients people = gymservice.update(clients, id);
		return ResponseEntity.ok().body(people);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		Optional<Clients> searchClient = gymservice.findId(id);
		if (searchClient.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado, digite um id válido!");
		}
		gymservice.deleteById(id);
		return ResponseEntity.ok().body("Cliente deletado com sucesso!");
	}
}