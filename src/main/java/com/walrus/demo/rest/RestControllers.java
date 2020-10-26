package com.walrus.demo.rest;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walrus.demo.entity.User;
import com.walrus.demo.service.TwitterService;
import com.walrus.demo.entity.Tweets;

@RestController
@RequestMapping("/api")
public class RestControllers {
	
	private TwitterService service;
	
	@Autowired
	private RestControllers(TwitterService service) {
		this.service=service;
		
	}
    /*For user registration*/
	@PostMapping("/reg")
	public String register(@RequestBody User user){	
	   return service.register(user);
	}
	/*For creating a post*/
	@PostMapping("/create")
	public String createPost(@RequestBody Tweets tweet){
		if(tweet.getDescription().length()<=140)
		  return service.createPost(tweet);
		return "post length should not be greater than 140 characters!!";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam BigInteger phone, @RequestParam String password){
		return service.login(phone, password);
	}
	//Search user 
	@GetMapping("/listusers")
	public List<User> getUsers(@RequestParam String screenname){
		return service.getUsers(screenname);
	}
	//Fetching post made by a user
	@GetMapping("/listpostsperuse")
	public List<Tweets> getUserspost(@RequestParam String screenname){
		return service.getUserspost(screenname);
	}
	//Follow a user
	@GetMapping("/follow")
	public void follow(@RequestParam String follower,@RequestParam String uscreenname){
		service.follow(follower, uscreenname);
	}
	//Liking a post
	@GetMapping("/like")
	public void follow(@RequestParam String follower,@RequestParam String uscreenname,@RequestParam Integer postid){
		service.like(follower, uscreenname, postid);
	}
	
	//Getting a feed at particular time based on the users we follow
	@GetMapping("/gFeed")
	public List<Tweets> getFeed(@RequestParam String screenname){
		return service.getFeed(screenname);
	}
}
