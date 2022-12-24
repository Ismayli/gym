package com.ismayli.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismayli.gym.model.Clients;
import com.ismayli.gym.repositories.GymRepository;

@Service
public class GymService {

	@Autowired
	private GymRepository gymRepository;

	public Object save(Clients clients) {
		return gymRepository.save(clients);
	}

	public Clients update(Clients clients, int id) {
		Clients updateClient = findById(id);
		updateClient.setBirthday(clients.getBirthday());
		updateClient.setEmail(clients.getEmail());
		updateClient.setName(clients.getName());
		updateClient.setId(clients.getId());
		updateClient.setPassword(clients.getPassword());
		return gymRepository.save(updateClient);
	}

	public Clients findById(int id) {
		Optional<Clients> client = gymRepository.findById(id);
		return client.orElse(null);
	}

	public void deleteById(int id) {
		gymRepository.deleteById(id);
	}

	public List<Clients> findAll() {
		return gymRepository.findAll();
	}

	public Optional<Clients> findId(int id) {
		return gymRepository.findById(id);
	}
}
