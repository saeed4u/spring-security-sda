package com.sda.spring.security.example.service;

import com.sda.spring.security.example.entities.Role;
import com.sda.spring.security.example.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role createRole(String name) throws Exception {
		Optional<Role> roleOptional = roleRepository.findByName(name);
		if (roleOptional.isPresent()){
			throw new Exception("Role with the same name exists!");
		}
		return roleRepository.save(new Role(name));
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
}
