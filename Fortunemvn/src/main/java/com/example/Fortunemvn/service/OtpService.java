package com.example.Fortunemvn.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.example.Fortunemvn.Response.BaseResponse;
import com.example.Fortunemvn.Response.OtpResponse;
import com.example.Fortunemvn.Response.OtpVerifyResponse;
import com.example.Fortunemvn.studentRepo.Events_registration;
import com.example.Fortunemvn.studentRepo.Events_registrationRepository;
import com.example.Fortunemvn.studentRepo.OTP;
import com.example.Fortunemvn.studentRepo.OTPReposiory;
import com.example.Fortunemvn.studentRepo.Registered_users;
import com.example.Fortunemvn.studentRepo.Registered_usersRepository;


@Component
public class OtpService {


	@Autowired 
	private EmailService emailService;

	@Autowired
	private OTPReposiory oTPReposiory;

	@Autowired
	Events_registrationRepository events_registrationRepository;


	@Autowired
	private Registered_usersRepository registered_usersRepository;

	public OtpResponse otpResponse(String toEmail) {
		OtpResponse response =new OtpResponse();
		String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
		System.out.println(otp);

		long longDate =System.currentTimeMillis();

		EmailDetails emailDetails =new EmailDetails();
		emailDetails.setSubject("Fortune OTP Task");
		emailDetails.setMsgBody("OTP for fortune task: "+otp);
		emailDetails.setRecipient(toEmail);

		String msg = emailService.sendSimpleMail(emailDetails);
		
		response.setOtp(otp);
		response.setOtpSendStaus(true);
		response.setEmail(toEmail);
		response.setMsg(msg);

		OTP otpObj =new OTP();

		otpObj.setOtp(otp);
		otpObj.setUpdatedDateTime(longDate);
		otpObj.setOtpStatus("Active");
		otpObj.setEmail(toEmail);

		oTPReposiory.save(otpObj);
		response.setOtpId(longDate);

		return response;
	}


	public Object verifyOtp(String email, String otp, long otpId) {
		Registered_users user = registered_usersRepository.findByEmail(email);
		OtpVerifyResponse res = new OtpVerifyResponse();
		OTP otpObj = oTPReposiory.findByEmailAndUpdatedDateTime(email,otpId);
		BaseResponse response = new BaseResponse();
		try {
			if(null!= otpObj && otpObj.getOtpStatus().equalsIgnoreCase("Expired")) {
				res.setMsg("OTP Expired, Please resend OTP");
				response.setResponse(res);
			}
			else if(null != user &&(null != otpObj && otp.equalsIgnoreCase(otpObj.getOtp()))) {
				if(null != user) {
					Events_registration events_registration = new Events_registration();
					events_registration.setUser_id(user.getId());

					events_registrationRepository.save(events_registration);
					otpObj.setVerifiedSuccess(true);
					otpObj.setOtpStatus("Expired");
					res.setMsg("OTP verified and user event resgistred successfuly");
					res.setVerifyStatus(true);
					res.setRedirectUrl("www.google.com");
					response.setResponse(res);
				}
			}
			else if(null != otpObj && otp.equalsIgnoreCase(otpObj.getOtp())){
				res.setVerifyStatus(true);
				otpObj.setVerifiedSuccess(true);
				res.setMsg("OTP verified successfuly");
				response.setResponse(res);
			}else {
				
				res.setVerifyStatus(false);
				res.setMsg("Incorrect OTP");
				response.setResponse(res);
			}
			oTPReposiory.save(otpObj);
		}
		catch (DataIntegrityViolationException e) {
			response.setResponse("OTP verified and user event resgistred successfuly");
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
