package com.sda.spring.security.example.service;

import com.sda.spring.security.example.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
	Role createRole(String name) throws Exception;
	List<Role> getAllRoles();
}
