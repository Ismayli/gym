package com.ismayli.gym.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ismayli.gym.model.Clients;

public interface GymRepository extends JpaRepository<Clients, Integer>{

}
