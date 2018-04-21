package edu.unk.cs406.user.profile.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.validation.ValidationPatterns;

public class UpdateProfileDTO {
	@Id
	@NotNull
	private String id;

	@NotNull
	private String label;
	
	@NotNull
	@Pattern(regexp = ValidationPatterns.EMAIL_PATTERN)
	private String email;
	
	@NotNull
	@Pattern(regexp = ValidationPatterns.PASSWORD_PATTERN)
	@Min(8)
	private String password;

	private String description;

	private List<ProfileEntity> userProfileEntities =  new ArrayList<ProfileEntity>();

	private List<String> userids =  new ArrayList<String>();

	private List<String> subscriptions =  new ArrayList<String>();


	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return this.label;
	}


	public void setLabel(String str) {
		// TODO Auto-generated method stub
		this.label = str;
	}

	public void setEmailID(String emailid)
	{
		this.email = emailid;
	}
	
	public String getEmailID()
	{
		return this.email;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
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

	
		public List<String> getComments() {
			// TODO Auto-generated method stub
			return null;
		}
	
	
		public void addComment(String comment) {
			// TODO Auto-generated method stub
			
		}
	
	
		public List<String> getLocations() {
			// TODO Auto-generated method stub
			return null;
		}
	
	
		public void addLocation(String location) {
			// TODO Auto-generated method stub
			
		}
	
	
		public List<String> getEvents() {
			// TODO Auto-generated method stub
			return null;
		}
	
	
		public void addEvent(String event) {
			// TODO Auto-generated method stub
			
		}


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
