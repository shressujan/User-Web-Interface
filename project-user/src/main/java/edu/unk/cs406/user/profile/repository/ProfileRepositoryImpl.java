package edu.unk.cs406.user.profile.repository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.group.entity.GroupEntity;
import edu.unk.cs406.user.profile.entity.ProfileEntity;

public class ProfileRepositoryImpl implements ProfileRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	public ProfileEntity updateProfileEntity(ProfileEntity profile) {
		Query query =  new Query(Criteria.where("id").is(profile.getId()));
		Update update =  new Update();
		update.set("label", profile.getLabel());
		update.set("emailID", profile.getEmailID());
		update.set("password", profile.getPassword());
		update.set("description", profile.getDescription());
		update.set("likes", profile.getLikes());
		update.set("comments", profile.getComments());
		update.set("location", profile.getLocations());
		update.set("events", profile.getEvents());
		update.set("lastModifiedDate", LocalDateTime.now());
		update.set("content", profile.getContent());
		update.set("subscriptions", profile.getSubscriptions());
		WriteResult result = null;
		result = mongoTemplate.updateFirst(query, update, ProfileEntity.class);

		if(result != null)
		{
			return profile;
		}
		return null;
	}
}
