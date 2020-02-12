package com.demo.hrsystem.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

	@NotBlank
	@Size(max = 40)
	private String name;

	@NotBlank
	@Size(max = 1)
	private String sex;

	@NotBlank
	@Size(max = 40)
	private String email;

	@NotBlank
	@Size(max = 15)
	private String mobile;

	@NotBlank
	@Size(max = 50)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}