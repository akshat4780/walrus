package com.walrus.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Tweets {
	@Id
  @Column(name="id")
  private int Post_id;
  @Column(name="description")
  private String description;
  @Column(name="screen_name")
  private String Screen_name;
public int getPost_id() {
	return Post_id;
}
public void setPost_id(int post_id) {
	Post_id = post_id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getScreen_name() {
	return Screen_name;
}
public void setScreen_name(String screen_name) {
	Screen_name = screen_name;
}
  
}
