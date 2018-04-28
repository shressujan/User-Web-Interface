package edu.unk.cs406.user.profile.dto;

import java.util.ArrayList;
import java.util.Collection;
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
import edu.unk.csit406.domain.Comment;
import edu.unk.csit406.domain.Location;
import edu.unk.scit406.event.entity.Event;

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

	private Collection<Comment> comments;
	
	private Collection<Location> locations;
	
	private Collection<Event> events; 
	
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


	public void setDescription(String str) {
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


	public void setLike(ProfileEntity profile) {
		// TODO Auto-generated method stub
		this.userProfileEntities.add(profile);
	}

	
		public Collection<Comment> getComments() {
			// TODO Auto-generated method stub
			return this.comments;
		}
	
	
		public void setComment(Comment comment) {
			// TODO Auto-generated method stub
			this.comments.add(comment);
		}
	
	
		public Collection<Location> getLocations() {
			// TODO Auto-generated method stub
			return this.locations;
		}
	
	
		public void setLocation(Location location) {
			// TODO Auto-generated method stub
			this.locations.add(location);
		}
	
	
		public Collection<Event> getEvents() {
			// TODO Auto-generated method stub
			return this.events;
		}
	
	
		public void setEvent(Event event) {
			// TODO Auto-generated method stub
			this.events.add(event);
		}


	public List<String> getSubscriptions() {
		// TODO Auto-generated method stub
		return this.subscriptions;
	}


	public void setSubscriptions(String sub) {
		// TODO Auto-generated method stub
		this.subscriptions.add(sub);
	}


	public byte[] getContent() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setContent() {
		// TODO Auto-generated method stub

	}

}
