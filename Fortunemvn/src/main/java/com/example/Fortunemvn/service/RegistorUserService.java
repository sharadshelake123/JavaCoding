package com.example.Fortunemvn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.example.Fortunemvn.Response.BaseResponse;
import com.example.Fortunemvn.studentRepo.Events_registration;
import com.example.Fortunemvn.studentRepo.Events_registrationRepository;
import com.example.Fortunemvn.studentRepo.Registered_users;
import com.example.Fortunemvn.studentRepo.Registered_usersRepository;

@Component
public class RegistorUserService {
	
	@Autowired
	Registered_usersRepository registered_usersRepository;
	
	@Autowired
	Events_registrationRepository events_registrationRepository;

	public Object registorUser(Registered_users rUser) {
		// TODO Auto-generated method stub
		BaseResponse response =new BaseResponse();
		try {
			Registered_users user =  new Registered_users();
			user.setCityName(rUser.getCityName());
			user.setEmail(rUser.getEmail());
			user.setName(rUser.getName());
			user.setGrade(rUser.getGrade());
			user.setPhnoeNumber(rUser.getPhnoeNumber());
			user.setSchoolName(rUser.getSchoolName());
			user.setState(rUser.getState());
			
			registered_usersRepository.save(user);
			
			user = registered_usersRepository.findByEmail(rUser.getEmail());
			
			Events_registration events_registration = new Events_registration();
			
			events_registration.setUser_id(user.getId());
			
			events_registrationRepository.save(events_registration);
			
			response.setResponse("User Registered Successfully!!");
			
		} catch (DataIntegrityViolationException   e) {
			response.setResponse("User/Email already registered");
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		return response;
	}

}
