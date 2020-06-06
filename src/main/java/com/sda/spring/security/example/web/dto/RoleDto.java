package com.sda.spring.security.example.web.dto;

import javax.validation.constraints.NotEmpty;

public class RoleDto {

	@NotEmpty
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
