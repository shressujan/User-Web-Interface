package edu.unk.cs406.user.entity;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.csit406.domain.Comment;
import edu.unk.csit406.domain.Location;
import edu.unk.scit406.event.entity.Event;

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
	
	Collection<String> likes;
	
	Collection<String> comments;
	
	Collection<String> locations;
	
	Collection<String> events;
	
	byte[] content;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id =  id;
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
	public int getLikeCount() {
		return this.likes.size();
	}
	
	@Override
	public Collection<String> getLikes() {
		return likes;
	}

	@Override
	public void addLike(String user) {
		if(!likes.contains(user)) {
			likes.add(user);
		}
	}
	
	@Override
	public void deleteLike(ProfileEntity user) {
		if(likes.contains(user.getId())) {
			likes.remove(user.getId());
		}
	}
	
	@Override
	public Collection<String> getComments() {
		// TODO Auto-generated method stub
		return this.comments;
	}

	@Override
	public void addComment(String comment) {
		// TODO Auto-generated method stub
		this.comments.add(comment);
	}

	@Override
	public void deleteComment(String comment) {
		// TODO Auto-generated method stub
		this.comments.remove(comment);
	}

	@Override
	public Collection<String> getLocations() {
		// TODO Auto-generated method stub
		return this.locations;
	}

	@Override
	public void addLocation(String location) {
		// TODO Auto-generated method stub
		this.locations.add(location);
		
	}

	@Override
	public void deleteLocation(String location) {
		// TODO Auto-generated method stub
		this.locations.remove(location);
		
	}
	
	@Override
	public void addEvent(String event) {
		// TODO Auto-generated method stub
		if(!this.events.contains(event))
		{
			this.events.add(event);
		}
	}
	
	@Override
	public Collection<String> getEvents() {
		// TODO Auto-generated method stub
		return this.events;
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
