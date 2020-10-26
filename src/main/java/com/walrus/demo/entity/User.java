package com.walrus.demo.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	 @Id
	 @Column(name= "phone_number")
	 private BigInteger phonenumber;
  @Column(name= "uname")
  private String uname;
 
 
  @Column(name= "email")
  private String email;
  @Column(name= "password")
  private String password;
  @Column(name= "screen_name")
  private String screenname;
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public BigInteger getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(BigInteger phonenumber) {
	this.phonenumber = phonenumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getScreenname() {
	return screenname;
}
public void setScreenname(String screenname) {
	this.screenname = screenname;
}
  
}
