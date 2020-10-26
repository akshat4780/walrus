package com.walrus.demo.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walrus.demo.entity.User;
import com.walrus.demo.dao.TwitterDAO;
import com.walrus.demo.entity.Tweets;

@Service
public class TwitterServiceImpl implements TwitterService {
    private TwitterDAO dao;
    @Autowired
    private TwitterServiceImpl(TwitterDAO dao){
    	this.dao=dao;
    }
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#register(com.walrus.demo.entity.User)
	 */
	public String register( User user){	
		   return dao.register(user);
		}
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#login(java.math.BigInteger, java.lang.String)
	 */
	public String login(BigInteger phonenumber,String password){
		return dao.Login(phonenumber, password);
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#createPost(com.walrus.demo.entity.Tweets)
	 */
	public String createPost(Tweets tweet){
		return dao.createPost(tweet);
	}
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#getUsers(java.lang.String)
	 */
	public List<User> getUsers(String screenname){
		return dao.listUsers(screenname);
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#follow(java.lang.String, java.lang.String)
	 */
	public void follow(String follower,String screenname){
		dao.follow(follower, screenname);
	}
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#like(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	public void like(String follower,String screenname,Integer postid){
		dao.like(follower, screenname,postid);
	}
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#getUserspost(java.lang.String)
	 */
	public List<Tweets> getUserspost(String screenname) {
		return dao.listUsersposts(screenname);
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.service.TwitterService#getFeed(java.lang.String)
	 */
	public List<Tweets> getFeed(String screenname){
		return dao.getFeed(screenname);
	}
}
