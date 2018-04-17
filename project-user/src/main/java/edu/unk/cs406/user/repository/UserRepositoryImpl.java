package edu.unk.cs406.user.repository;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


import com.mongodb.client.result.UpdateResult;

import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.profile.entity.ProfileEntity;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;
	
//	public ProfileEntity updateUserProfileEntity(ProfileEntity profile) {
//		// TODO Auto-generated method stub
//		Query query =  new Query(Criteria.where("id").is(profile.getId()));
//		Update update =  new Update();
//		update.set("label", profile.getLabel());
//		update.set("description", profile.getDescription());
////		update.set("likes", profile.getLikes());
////		update.set("comments", profile.getComments());
////		update.set("location", profile.getLocations());
////		update.set("events", profile.getEvents());
////		update.set("subscriptions", profile.getSubscriptions());
////		update.set("content", profile.getContent());
//		
//		UpdateResult result = mongoTemplate.updateFirst(query, update, ProfileEntity.class);
//		
//		if(result !=  null)
//		{
//			return profile;
//		}
//		return null;
//	}
	
	@Override
	public UserEntity updateUserEntity(UserEntity user) {
		// TODO Auto-generated method stub
		
		if(user instanceof ProfileEntity)
		{
			
		}
		return null;
	}

}
