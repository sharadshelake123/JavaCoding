package com.example.Fortunemvn.Response;

public class OtpResponse {
	
	private String otp;
	private Long otpId;
	private boolean otpSendStaus;
	private String email;
	private String msg;
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public boolean isOtpSendStaus() {
		return otpSendStaus;
	}
	public void setOtpSendStaus(boolean otpSendStaus) {
		this.otpSendStaus = otpSendStaus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getOtpId() {
		return otpId;
	}
	public void setOtpId(Long otpId) {
		this.otpId = otpId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
