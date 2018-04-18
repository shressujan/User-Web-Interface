package edu.unk.cs406.user.entity;

import java.util.Date;

import edu.unk.cs406.user.profile.entity.ProfileEntity;

public interface User {
	public String getId();
	public String getLabel();
	public void setLabel(String str);
	public String getDescription();
	public void setDescription(String str);
	public Date getCreatedDate();
	public Date getLastModifiedDate();
	public int getLikes();
	public void addLike(ProfileEntity user);
		//TODO: List of Comment getter
	//public List<> getComments();
		//TODO: List of locations getter
	//public List<> getLocations();
		//TODO: List of Events getter
	//public List<> getEvents();
	public byte[] getContent();
	public void setContent();
}