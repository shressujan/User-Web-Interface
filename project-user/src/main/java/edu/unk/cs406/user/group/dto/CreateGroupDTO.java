package edu.unk.cs406.user.group.dto;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class CreateGroupDTO {
	
	@Id
	@NotNull
	private String id;

	@NotNull
	String label;
	
	String description;
	
	Collection<String> likes;
	
	Collection<String> admins;
	
	Collection<String> moderators;
	
	Collection<String> members;
	
	byte[] content;
	
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void setId(String id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<String> getLikes() {
		return likes;
	}

	public void setLikes(Collection<String> likes) {
		this.likes = likes;
	}

	public Collection<String> getAdmins() {
		return admins;
	}

	public void setAdmins(Collection<String> admins) {
		this.admins = admins;
	}

	public Collection<String> getModerators() {
		return moderators;
	}

	public void setModerators(Collection<String> moderators) {
		this.moderators = moderators;
	}

	public Collection<String> getMembers() {
		return members;
	}

	public void setMembers(Collection<String> members) {
		this.members = members;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
}
