package com.xworkz.cm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "registration_details")
public class RegisterEntity  implements Serializable  {
	
	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "ID")
	private int id;
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE_NO")
	private Long phoneNo;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "AGREE")
	private String isAgree;
	@Column(name = "COURSE_TYPE")
	private String courseType;
	@Column(name = "COUNT")
	private int count;

	private static final Logger logger = Logger.getLogger(RegisterEntity.class);

	public RegisterEntity() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "RegisterEntity [id=" + id + ", userId=" + userId + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", password=" + password + ", isAgree=" + isAgree + ", courseType=" + courseType + ", count=" + count
				+ "]";
	}

	

}
