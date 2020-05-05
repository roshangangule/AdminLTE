package com.javabykiran.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user1")
public class Admin2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobileNumber;

	@Column(name = "gender")
	private String gender;

	@Column(name = "course")
	private String course;

	@Column(name = "password")
	private String password;

	@Column(name = "isDefault")
	private String isDefault;

	@OneToOne
	@JoinColumn(name = "sid")
	private State theState;

	public Admin2() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public State getTheState() {
		return theState;
	}

	public void setTheState(State theState) {
		this.theState = theState;
	}

	@Override
	public String toString() {
		return "Admin2 [id=" + id + ", username=" + username + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", gender=" + gender + ", course=" + course + ", password=" + password + ", isDefault=" + isDefault
				+ ", theState=" + theState + "]";
	}

}
