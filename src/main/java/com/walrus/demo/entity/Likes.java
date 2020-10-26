package com.walrus.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="post_likes")
	public class Likes {
		@Id
		@Column(name="id")
		private int id;
		@Column(name="screen_name")
		private String screenname;
		@Column(name="likedby")
		private String likedby;
		@Column(name="post_id")
		private Integer postid;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getScreenname() {
			return screenname;
		}
		public void setScreenname(String screenname) {
			this.screenname = screenname;
		}
		public String getLikedby() {
			return likedby;
		}
		public void setLikedby(String likedby) {
			this.likedby = likedby;
		}
		public Integer getPostid() {
			return postid;
		}
		public void setPostid(Integer postid) {
			this.postid = postid;
		}
		
		

}
