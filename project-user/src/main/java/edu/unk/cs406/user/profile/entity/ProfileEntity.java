package edu.unk.cs406.user.profile.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.validation.ValidationPatterns;


public class ProfileEntity extends UserEntity{
	
	
	@NotNull
	@Pattern(regexp = ValidationPatterns.EMAIL_PATTERN)
	private String emailID;
	
	@NotNull
	@Pattern(regexp = ValidationPatterns.PASSWORD_PATTERN)
	@Min(8)
	private String password;
	
	private Collection<String> subscriptions =  new ArrayList<String>();

	public void setEmailID(String emailid)
	{
		this.emailID = emailid;
	}
	
	public String getEmailID()
	{
		return this.emailID;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public Collection<String> getSubscriptions() {
		return this.subscriptions;

	}
	
	public void addSubscriptions(String sub) {
		if(!subscriptions.contains(sub)) {
			subscriptions.add(sub);
		}
	}
	
}
