package edu.unk.cs406.user.group.entity;

import java.util.Collection;

import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.profile.entity.ProfileEntity;

public class GroupEntity extends UserEntity {
	
	Collection<String> admins;
	
	Collection<String> moderators;
	
	Collection<String> members;
	
	public Collection<String> getAdmins() {
		return admins;
	}
	
	public boolean isAdmin(ProfileEntity user) {
		return admins.contains(user.getId());
	}
	
	public void addAdmin(ProfileEntity user) {
		admins.add(user.getId());
	}
	
	public Collection<String> getModerators() {
		return moderators;
	}
	
	public boolean isModerator(ProfileEntity user) {
		return moderators.contains(user.getId());
	}
	
	public void addModerator(ProfileEntity user) {
		moderators.add(user.getId());
	}
	
	public Collection<String> getMembers() {
		return members;
	}
	
	public boolean isMember(ProfileEntity user) {
		return members.contains(user.getId());
	}
	
	public void addMember(ProfileEntity user) {
		members.add(user.getId());
	}
}
