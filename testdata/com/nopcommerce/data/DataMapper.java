package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.GlobalConstants;

public class DataMapper {
	public static DataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/DataTest.json"), DataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@JsonProperty("login")
	 Login login;

	static class Login {
		@JsonProperty("username")
		  String username;
       
		@JsonProperty("password")
		  String password;

	}

	public String getUsename() {
		return login.username;
	}

	public String getPassword() {
			return login.password;
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("address")
	private String address;

	@JsonProperty("birthday")
	private String birthday;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getBirthday() {
		return birthday;
	}

}
