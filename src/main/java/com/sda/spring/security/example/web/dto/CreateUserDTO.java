package com.sda.spring.security.example.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CreateUserDTO {
	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@Email
	@NotEmpty
	private String email;

	@NotEmpty
	private Long roleId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
