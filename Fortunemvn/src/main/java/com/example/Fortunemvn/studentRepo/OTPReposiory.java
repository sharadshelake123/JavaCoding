package com.example.Fortunemvn.studentRepo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPReposiory extends JpaRepository<OTP, String> {

	OTP findByEmailAndUpdatedDateTime(String email,long updatedDateTime);

}
