package com.spring.andre.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.andre.demo.dto.UserDTO;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	@Nationalized
	private String name;
	@Column(name = "email")
	@Nationalized
	private String email;
	@Column(name = "county")
	@Nationalized
	private String county;
	@Column(name = "language")
	@Nationalized
	private String language;
	@Column(name = "password")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@Column(name = "address")
	@Nationalized
	private String address;
	@Column(name = "phoneNumber")
	private int phoneNumber;
	@Column(name = "dateBirth")
	private Date dateBirth;
	@Column(name = "permissions")
	private String permissions;
	@Column(name = "image")
	private String imagePath;
	@Column(name = "imageFileName")
	private String imageFileName;
	@Column(name = "agentType")
	private String agentType;
	@Column(name = "agentSociety")
	private String agentSociety;
	@Column(name = "active")
	private boolean active;

	public User() {

	}

	public User(String id, String name, String email, String password, String permissions, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.permissions = permissions;
		this.active = active;
	}

	public User(UserDTO userDTO) {
		this.name = userDTO.getName();
		this.email = userDTO.getEmail();
		this.county = userDTO.getCounty();
		this.language = userDTO.getLanguage();
		this.password = userDTO.getPassword();
		this.address = userDTO.getAddress();
		this.phoneNumber = userDTO.getPhoneNumber();
		this.dateBirth = userDTO.getDateBirth();
		this.permissions = userDTO.getPermissions();
		this.imagePath = userDTO.getImagePath();
		this.imageFileName = userDTO.getImageFileName();
		this.agentType = userDTO.getAgentType();
		this.agentSociety = userDTO.getAgentSociety();
	}
	
	public User(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getAgentSociety() {
		return agentSociety;
	}

	public void setAgentSociety(String agentSociety) {
		this.agentSociety = agentSociety;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() { 
		return this.name + " + " + this.email + " + " + this.county + " + " + this.language + " + " + this.address + " + " + this.phoneNumber + " + " + this.dateBirth + " + " + this.imagePath + " + " + this.imageFileName + " + " + this.agentType + " + " + this.agentSociety + " + " + "With the following id: " + this.id;
 	}
}