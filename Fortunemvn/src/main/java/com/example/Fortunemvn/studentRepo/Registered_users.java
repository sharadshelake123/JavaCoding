package com.example.Fortunemvn.studentRepo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "Registered_users")
public class Registered_users implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7891687087165123382L;
	 
	@Id
	@ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	private String name;
	private String grade;
	@Column(nullable = false, unique = true)
	private String email;
	private String phnoeNumber;
	private String state;
	private String cityName;
	private String schoolName;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhnoeNumber() {
		return phnoeNumber;
	}
	public void setPhnoeNumber(String phnoeNumber) {
		this.phnoeNumber = phnoeNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
	
	
	

}
