package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Role;
import com.greatlearning.entity.User;

public interface ICredentialService {

	Role addNewRole(String role);

	User addNewUser(String userName, String password, String role_name);

	List<Role> listAllRoles();

}
