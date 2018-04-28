package edu.unk.cs406.user.entity;

import java.util.Collection;
import java.util.Date;

import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.csit406.domain.Comment;
import edu.unk.csit406.domain.Location;
import edu.unk.scit406.event.entity.Event;

public interface User {
	public String getId();
	public void setId(String id);
	public String getLabel();
	public void setLabel(String str);
	public String getDescription();
	public void setDescription(String str);
	public Date getCreatedDate();
	public Date getLastModifiedDate();
	public int getLikeCount();
	public Collection<String> getLikes();
	public void addLike(String user);
	public void deleteLike(ProfileEntity user);
	public Collection<String> getComments();
	public void addComment(String comment);
	public void deleteComment(String comment);
	public Collection<String> getLocations();
	public void addLocation(String location);
	public void deleteLocation(String location);
	public void addEvent(String event);
	public Collection<String> getEvents();
	public byte[] getContent();
	public void setContent(byte[] content);
}