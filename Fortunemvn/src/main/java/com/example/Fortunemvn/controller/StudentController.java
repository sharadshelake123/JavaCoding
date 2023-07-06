package com.example.Fortunemvn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.Fortunemvn.Response.BaseResponse;
import com.example.Fortunemvn.Response.OtpResponse;
import com.example.Fortunemvn.Response.OtpVerifyResponse;
import com.example.Fortunemvn.service.OtpService;
import com.example.Fortunemvn.service.RegistorUserService;
import com.example.Fortunemvn.studentRepo.Registered_users;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StudentController {
	 
	 @Autowired
	 private OtpService otpService;
	 
	 @Autowired
	 private RegistorUserService registorUserService;
	 
	 @PostMapping("/sendOtp")
	 @ApiOperation(value = "To send otp on email", response = OtpResponse.class)
	 @ApiResponses(value = {@ApiResponse(code = 204, message = "No content"),
			 @ApiResponse(code = 304, message = "Not modified"),
			 @ApiResponse(code = 500, message = "Internal Server Error"),
			 @ApiResponse(code = 406, message = "Not Accepted")})
	 public ResponseEntity<BaseResponse> sentOtp(
			 @RequestHeader(value = "email", required = true) String email){
		 
		 BaseResponse baseResponse = new BaseResponse();
		 baseResponse.setResponse(otpService.otpResponse(email));
		 
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	 }
	 
	 @PostMapping("/registerUser")
	 @ApiOperation(value = "Student Registration", response = BaseResponse.class)
	 @ApiResponses(value = {@ApiResponse(code = 204, message = "No content"),
			 @ApiResponse(code = 304, message = "Not modified"),
			 @ApiResponse(code = 500, message = "Internal Server Error"),
			 @ApiResponse(code = 406, message = "Not Accepted")})
	 public ResponseEntity<BaseResponse> registorUser(
			 @RequestBody Registered_users rUser){
		 
		 BaseResponse baseResponse = new BaseResponse();
		 baseResponse.setResponse(registorUserService.registorUser(rUser));
		 
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	 }
	 
	 @PostMapping("/verifyOtp")
	 @ApiOperation(value = "Verify otp", response = OtpVerifyResponse.class)
	 @ApiResponses(value = {@ApiResponse(code = 204, message = "No content"),
			 @ApiResponse(code = 304, message = "Not modified"),
			 @ApiResponse(code = 500, message = "Internal Server Error"),
			 @ApiResponse(code = 406, message = "Not Accepted")})
	 public ResponseEntity<BaseResponse> verifyOtp(
			 @RequestHeader(value = "email", required = true) String email,
			 @RequestHeader(value = "otp", required = true) String otp,
			 @RequestHeader(value = "otpId")long otpId){
		 
		 BaseResponse baseResponse = new BaseResponse();
		 baseResponse.setResponse(otpService.verifyOtp(email,otp,otpId));
		 
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	 }
	 
}
