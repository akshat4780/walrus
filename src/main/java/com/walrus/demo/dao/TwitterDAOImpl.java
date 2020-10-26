package com.walrus.demo.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.walrus.demo.entity.Follows;
import com.walrus.demo.entity.Likes;
import com.walrus.demo.entity.User;
import com.walrus.demo.entity.Tweets;

@Repository
public class TwitterDAOImpl implements TwitterDAO {
private EntityManager entityManager;
	
	@Autowired
	public TwitterDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#register(com.walrus.demo.entity.User)
	 */
	@Transactional
	public String register(User user){
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(user);
		return "Registered succesfully!";
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#createPost(com.walrus.demo.entity.Tweets)
	 */
	@Transactional
	public String createPost(Tweets tweets){
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(tweets);
		return "Post created successfully!";
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#Login(java.math.BigInteger, java.lang.String)
	 */
	@Transactional
	public String Login(BigInteger phonenumber, String password){
		Session currentSession=entityManager.unwrap(Session.class);
		String hql = "from User s where s.phonenumber = :pnum and s.password=:pass";
		List<User> result = currentSession.createQuery(hql)
		.setParameter("pnum", phonenumber).setParameter("pass", password)
		.list();
		if(result.size() > 0)
	    	return "Successfully logged in!";
		return "Userid or password wrong!!";
	}
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#listUsers(java.lang.String)
	 */
	@Transactional
	public List<User> listUsers(String screenname){
		Session currentSession=entityManager.unwrap(Session.class);
		String hql = "from User s where s.screenname like :name";
		List<User> result = currentSession.createQuery(hql)
		.setParameter("name",'%'+screenname+'%')
		.list();
		User theUser=null;
		if(result.size() > 0)
	    	return result;
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#listUsersposts(java.lang.String)
	 */
	@Transactional
	public List<Tweets> listUsersposts(String screenname){
		Session currentSession=entityManager.unwrap(Session.class);
		String hql = "from Tweets s where s.Screen_name = :name";
		List<Tweets> result = currentSession.createQuery(hql)
		.setParameter("name",screenname)
		.list();
		if(result.size() > 0)
	    	return result;
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#follow(java.lang.String, java.lang.String)
	 */
	@Transactional
	public void follow(String follower,String screenname){
		Session currentSession=entityManager.unwrap(Session.class);
		Follows f=new Follows();
		f.setFollowers(follower);
		f.setScreenname(screenname);
		currentSession.save(f);
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#like(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Transactional
	public void like(String follower,String screenname, Integer postid){
		Session currentSession=entityManager.unwrap(Session.class);
		Likes like=new Likes();
		like.setPostid(postid);
		like.setScreenname(screenname);
		like.setLikedby(follower);
		currentSession.save(like);
	}
	
	/* (non-Javadoc)
	 * @see com.walrus.demo.dao.TwitterDAO#getFeed(java.lang.String)
	 */
	@Transactional
	public List<Tweets> getFeed(String screenname){
		Session currentSession=entityManager.unwrap(Session.class);
		String hql = "from Follows s where s.followers = :name";
		List<Follows> result = currentSession.createQuery(hql)
		.setParameter("name",screenname)
		.list();
		List<Tweets> list=new ArrayList<Tweets>();
		String hql2 = "from Tweets s where s.Screen_name = :name";
		if(result.size() > 0){
			for(Follows t:result){
				List<Tweets> res = currentSession.createQuery(hql2)
						.setParameter("name",t.getScreenname())
						.list();
				list.addAll(res);
			}
	        
		}
		return list;
	}
	
	
}
