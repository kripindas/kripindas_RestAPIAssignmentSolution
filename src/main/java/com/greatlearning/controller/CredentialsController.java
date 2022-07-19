package com.greatlearning.controller;

import java.util.List;

import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;
import com.greatlearning.service.ICredentialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class CredentialsController {

	@Autowired
	private ICredentialService credentialService;

	@PostMapping("/addrole")
	public Role addRole(String name) {
		return credentialService.addNewRole(name);
	}

	@RequestMapping("/adduser")
	public User addUser(String username, String password, String role_name) {
		return credentialService.addNewUser(username, password, role_name);
	}

	@GetMapping("/listroles")
	public List<Role> listRoles() {
		return credentialService.listAllRoles();
	}
}
