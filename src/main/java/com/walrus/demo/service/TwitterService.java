package com.walrus.demo.service;

import java.math.BigInteger;
import java.util.List;

import com.walrus.demo.entity.Tweets;
import com.walrus.demo.entity.User;

public interface TwitterService {

	String register(User user);

	String login(BigInteger phonenumber, String password);

	String createPost(Tweets tweet);

	List<User> getUsers(String screenname);

	void follow(String follower, String screenname);

	void like(String follower, String screenname, Integer postid);

	List<Tweets> getUserspost(String screenname);

	List<Tweets> getFeed(String screenname);

}