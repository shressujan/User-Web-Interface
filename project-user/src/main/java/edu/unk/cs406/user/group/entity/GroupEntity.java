package edu.unk.cs406.user.group.entity;

import java.util.Collection;

import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.profile.entity.ProfileEntity;

public class GroupEntity extends UserEntity {
	
	Collection<ProfileEntity> admins;
	
	Collection<ProfileEntity> moderators;
	
	Collection<ProfileEntity> members;
	
	public Collection<ProfileEntity> getAdmins() {
		return admins;
	}
	
	public boolean isAdmin(ProfileEntity user) {
		return admins.contains(user);
	}
	
	public void addAdmin(ProfileEntity user) {
		admins.add(user);
	}
	
	public Collection<ProfileEntity> getModerators() {
		return moderators;
	}
	
	public boolean isModerator(ProfileEntity user) {
		return moderators.contains(user);
	}
	
	public void addModerator(ProfileEntity user) {
		moderators.add(user);
	}
	
	public Collection<ProfileEntity> getMembers() {
		return members;
	}
	
	public boolean isMember(ProfileEntity user) {
		return members.contains(user);
	}
	
	public void addMember(ProfileEntity user) {
		members.add(user);
	}
}
