package edu.unk.cs406.user.profile.dto;

import java.util.ArrayList;
import java.util.List;


import javax.validation.constraints.NotNull;

import edu.unk.cs406.user.profile.entity.ProfileEntity;

public class UpdateUserProfileDTO {

	@org.springframework.data.annotation.Id
	@NotNull
	private String id;
	
	@org.springframework.data.annotation.Id
	@NotNull
	private String label;

	private String description;

	private List<ProfileEntity> userProfileEntities =  new ArrayList<ProfileEntity>();

	private List<String> userids =  new ArrayList<String>();

	private List<String> subscriptions =  new ArrayList<String>();



	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}


	public String getLabel() {
		// TODO Auto-generated method stub
		return this.label;
	}


	public void setLabel(String str) {
		// TODO Auto-generated method stub
		this.label = str;
	}


	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}


	public void addDescription(String str) {
		// TODO Auto-generated method stub
		this.description = str;
	}


	public List<String> getLikes() {
		// TODO Auto-generated method stub
		for(ProfileEntity p: this.userProfileEntities)
		{
			this.userids.add(p.getId());
		}
		return this.userids;
	}


	public void addLike(ProfileEntity profile) {
		// TODO Auto-generated method stub
		this.userProfileEntities.add(profile);
	}

	//
	//	public List<Comment> getComments() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//
	//	public void addComment(Comment comment) {
	//		// TODO Auto-generated method stub
	//		
	//	}
	//
	//
	//	public List<Location> getLocations() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//
	//	public void addLocation(Location location) {
	//		// TODO Auto-generated method stub
	//		
	//	}
	//
	//
	//	public List<Event> getEvents() {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//
	//	public void addEvent(Event event) {
	//		// TODO Auto-generated method stub
	//		
	//	}


	public List<String> getSubscriptions() {
		// TODO Auto-generated method stub
		return this.subscriptions;
	}


	public void addSubscriptions(String sub) {
		// TODO Auto-generated method stub
		this.subscriptions.add(sub);
	}


	public byte[] getContent() {
		// TODO Auto-generated method stub
		return null;
	}


	public void addContent() {
		// TODO Auto-generated method stub

	}


}
