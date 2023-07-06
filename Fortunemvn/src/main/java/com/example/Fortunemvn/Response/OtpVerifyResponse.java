package com.example.Fortunemvn.Response;

public class OtpVerifyResponse {
	
	private String msg;
	private boolean verifyStatus;
	private String redirectUrl;
	
	public boolean isVerifyStatus() {
		return verifyStatus;
	}
	public void setVerifyStatus(boolean verifyStatus) {
		this.verifyStatus = verifyStatus;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	

}
