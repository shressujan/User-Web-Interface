package edu.unk.cs406.user.profile.entity;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import edu.unk.cs406.user.entity.User;

public class ProfileEntity implements User {
	
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

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLabel() {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescription() {
		// TODO Auto-generated method stub
		
	}

	public Date getCreatedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getLastModifiedDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLikes() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void addLike(ProfileEntity user) {
		// TODO Auto-generated method stub
		
	}

	public byte[] getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setContent() {
		// TODO Auto-generated method stub
		
	}
	
}
