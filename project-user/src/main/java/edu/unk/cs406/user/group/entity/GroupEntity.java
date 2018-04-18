package edu.unk.cs406.user.group.entity;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.profile.entity.ProfileEntity;

public class GroupEntity extends UserEntity {

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
	
	Collection<ProfileEntity> admins;
	
	Collection<ProfileEntity> moderators;
	
	Collection<ProfileEntity> members;
	
	byte[] content;

	

}
