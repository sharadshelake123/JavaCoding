package com.example.Fortunemvn.studentRepo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Registered_usersRepository extends JpaRepository<Registered_users, String> {

	Registered_users findByEmail(String toEmail);
}
