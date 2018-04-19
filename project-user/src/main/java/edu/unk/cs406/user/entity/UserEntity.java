package edu.unk.cs406.user.entity;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unk.cs406.user.profile.entity.ProfileEntity;

@Document(collection= "users")
public class UserEntity implements User {

	@Id
	@NotNull
	String id;
	
	@NotNull
	String label;
	
	String description;
	
	@CreatedDate
	Date createdDate;
	
	@LastModifiedDate
	Date lastModifiedDate;
	
	Collection<ProfileEntity> likes;
	
	byte[] content;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String str) {
		this.label = str;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String str) {
		this.description = str;
	}

	@Override
	public Date getCreatedDate() {
		return createdDate;
	}

	@Override
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	@Override
	public int getLikes() {
		return this.likes.size();
	}

	@Override
	public void addLike(ProfileEntity user) {
		if(!likes.contains(user)) {
			likes.add(user);
		}
		
	}
	
	@Override
	public void deleteLike(ProfileEntity user) {
		if(likes.contains(user)) {
			likes.remove(user);
		}
	}
	
	@Override
	public Collection<String> getComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addComment(ProfileEntity user, String comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(String commentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<String> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLocation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLocation(String locationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<String> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getContent() {
		return content;
	}

	@Override
	public void setContent(byte[] content) {
		this.content = content;
	}

}
