package com.project.cmsproject.service;

import java.util.Optional;

import com.project.cmsproject.entities.ERole;
import com.project.cmsproject.entities.Role;
import com.project.cmsproject.entities.User;



public interface UserService {

	public User addUserEntity(User user);

	public String updateRole(Integer userId, Role role);

	public Optional<User> findByUsername(String username);

	public Boolean existsByUsername(String username);

	public Optional<User> findByRole(ERole role);
}