package edu.unk.cs406.user.group.entity;

import java.util.Collection;

import edu.unk.cs406.user.entity.User;
import edu.unk.cs406.user.profile.Profile;

public class Group implements User {

	private String id;
	private String label;
	private String description;
	private Collection<Profile> likes;
	private Collection<Profile> admins;
	private Collection<Profile> moderators;
	private Collection<Profile> members;
	private byte[] content;
	
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
	public int getLikes() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void addLike(Profile user) {
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
