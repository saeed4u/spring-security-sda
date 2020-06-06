package com.sda.spring.security.example.web;

import com.sda.spring.security.example.entities.Role;
import com.sda.spring.security.example.service.RoleService;
import com.sda.spring.security.example.web.dto.RoleDto;
import com.sda.spring.security.example.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("roles")
public class RoleController {

	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@ModelAttribute("role")
	public RoleDto roleDto() {
		return new RoleDto();
	}

	@GetMapping
	public ModelAndView getAllRoles(){
		ModelAndView modelAndView = new ModelAndView("role/all");
		List<Role> roles = roleService.getAllRoles();
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@GetMapping("create")
	public String createRole(){
		return "role/create";
	}

	@PostMapping("create")
	public String createRole(@ModelAttribute("role") RoleDto roleDto) throws Exception {
		roleService.createRole(roleDto.getRoleName());
		return "redirect:/roles";
	}



}
