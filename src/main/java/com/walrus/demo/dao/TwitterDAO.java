package com.walrus.demo.dao;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import com.walrus.demo.entity.Tweets;
import com.walrus.demo.entity.User;

public interface TwitterDAO {

	String register(User user);

	String createPost(Tweets tweets);

	String Login(BigInteger phonenumber, String password);

	List<User> listUsers(String screenname);

	List<Tweets> listUsersposts(String screenname);

	void follow(String follower, String screenname);

	void like(String follower, String screenname, Integer postid);

	List<Tweets> getFeed(String screenname);

}