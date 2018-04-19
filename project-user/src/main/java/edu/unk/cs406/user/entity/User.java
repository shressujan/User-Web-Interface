package edu.unk.cs406.user.entity;

import java.util.Collection;
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
	public int getLikeCount();
	public Collection<String> getLikes();
	public void addLike(ProfileEntity user);
	public void deleteLike(ProfileEntity user);
	public Collection<String> getComments();
	public void addComment(ProfileEntity user, String comment);
	public void deleteComment(String commentId);
	public Collection<String> getLocations();
	public void addLocation();
	public void deleteLocation(String locationId);
	public void addEvent(String event);
	public Collection<String> getEvents();
	public byte[] getContent();
	public void setContent(byte[] content);
}