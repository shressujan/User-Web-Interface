package edu.unk.cs406.user.entity;

import edu.unk.cs406.user.profile.Profile;

public interface User {
	public String getId();
	public String getLabel();
	public void setLabel();
	public String getDescription();
	public void setDescription();
	public int getLikes();
	public void addLike(Profile user);
		//TODO: List of Comment getter
	//public List<> getComments();
		//TODO: List of locations getter
	//public List<> getLocations();
		//TODO: List of Events getter
	//public List<> getEvents();
	public byte[] getContent();
	public void setContent();
}