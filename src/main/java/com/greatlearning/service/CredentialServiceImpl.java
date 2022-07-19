package com.greatlearning.service;

import java.util.ArrayList;
import java.util.List;

import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;
import com.greatlearning.repository.RoleRepository;
import com.greatlearning.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements ICredentialService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role addNewRole(String roleName) {
		Role role = roleRepository.findRoleByName(roleName);
		if (role != null)
			return role;
		role = new Role();
		role.setName(roleName);
		return roleRepository.save(role);
	}

	@Override
	public User addNewUser(String userName, String password, String role_name) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);

		List<Role> roles = new ArrayList<>();
		Role role = roleRepository.findRoleByName(role_name);
		if (role == null) {
			role = addNewRole(role_name);
		}
		roles.add(role);
		user.setListOfRoles(roles);

		return userRepository.save(user);
	}

	@Override
	public List<Role> listAllRoles() {
		return roleRepository.findAll();
	}

}
