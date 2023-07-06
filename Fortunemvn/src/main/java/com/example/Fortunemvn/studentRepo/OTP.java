package com.example.Fortunemvn.studentRepo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OTP")
public class OTP implements Serializable {
	
	private static final long serialVersionUID = -4595521266875720022L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	private String user_id;
	private String otpStatus;
	private boolean isVerifiedSuccess;
	private String otp;
	private long updatedDateTime;
	private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 5 minutes
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public long getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(long updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public static long getOtpValidDuration() {
		return OTP_VALID_DURATION;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isVerifiedSuccess() {
		return isVerifiedSuccess;
	}
	public void setVerifiedSuccess(boolean isVerifiedSuccess) {
		this.isVerifiedSuccess = isVerifiedSuccess;
	}
	public String getOtpStatus() {
		return otpStatus;
	}
	public void setOtpStatus(String otpStatus) {
		this.otpStatus = otpStatus;
	}
}
