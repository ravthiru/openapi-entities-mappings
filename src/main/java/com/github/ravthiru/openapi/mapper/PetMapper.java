package com.github.ravthiru.openapi.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.github.ravthiru.openapi.repository.PetEntity;
import com.github.ravthiru.petstore.api.model.v1.Pet;

@Mapper
public interface PetMapper {

	public static PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

	@Mappings({
		@Mapping(target = "petId", source = "id"),
		@Mapping(target = "petName", source = "name"),
	   })
	PetEntity mapTo(Pet pet);
	
	@InheritInverseConfiguration
	Pet mapTo(PetEntity petEntity);
	
}
