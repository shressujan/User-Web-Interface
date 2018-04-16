package edu.unk.cs406.user.entity;

import edu.unk.cs406.user.enums.Permissions;

public interface User {
	public String getId();
	public String getLabel();
	public void setLabel();
	public String getDescription();
	public void setDescription();
	
	public Permissions getPermissions();
	public boolean setPermissions();
	public int getLikes();
	public void addLike(User user);
	
	//TODO: List of Comment getter
	
	//TODO: List of locations getter
	
	//TODO: List of Events getter
	
	public byte[] getContent();
	public void setContent();
}