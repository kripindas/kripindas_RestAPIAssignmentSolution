package com.greatlearning.repository;

import com.greatlearning.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User getUserByUserName(String userName);

}
