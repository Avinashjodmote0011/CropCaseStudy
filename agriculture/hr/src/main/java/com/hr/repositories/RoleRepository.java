package com.hr.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hr.model.ERole;
import com.hr.model.Role;



public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(ERole name);
}
