package com.github.ravthiru.openapi.controller;

import java.net.URI;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.ravthiru.openapi.mapper.PetMapper;
import com.github.ravthiru.openapi.repository.PetEntity;
import com.github.ravthiru.openapi.repository.PetsRepository;
import com.github.ravthiru.petstore.api.model.v1.Pet;

@RestController
public class PetStoreController {

	@Autowired
	PetsRepository petsRepository;

	@GetMapping(value = "/pets/{id}", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Pet> getCourse(@PathVariable("id") long id, Model model) {
		PetEntity petEntity = petsRepository.getOne(id);
		Pet pet = PetMapper.INSTANCE.mapTo(petEntity);
		return ResponseEntity.accepted().body(pet);
	}

	@PostMapping("/pets")
	public ResponseEntity<Pet> createCourse(@RequestBody Pet pet) {

		PetEntity petEntity = PetMapper.INSTANCE.mapTo(pet);

		PetEntity savedPet = petsRepository.save(petEntity);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedPet.getPetId()).toUri();

		return ResponseEntity.created(location).build();

	}

}
