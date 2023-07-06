package com.example.Fortunemvn.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Fortunemvn.model.Users;


@Repository
public interface UserDao extends CrudRepository<Users, Integer> {
	Users findByUsername(String username);
}