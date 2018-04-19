package edu.unk.cs406.user.profile.entity;

import java.util.ArrayList;
import java.util.Collection;

import edu.unk.cs406.user.entity.UserEntity;

public class ProfileEntity extends UserEntity{
	
	private Collection<String> subscriptions =  new ArrayList<String>();

	public Collection<String> getSubscriptions() {
		return this.subscriptions;

	}
	
	public void addSubscriptions(String sub) {
		if(!subscriptions.contains(sub)) {
			subscriptions.add(sub);
		}
	}
	
}
