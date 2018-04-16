package edu.unk.cs406.user;

public interface User {
	public String getId();
	public String getLabel();
	public void setLabel();
	public String getDescription();
	public void setDescription();
	
	//TODO: Access Enum for public/private and getter
	public int getLikes();
	public void addLike(User user);
	
	//TODO: List of Comment getter
	
	//TODO: List of locations getter
	
	//TODO: List of Events getter
	
	public byte[] getContent();
	public void setContent();
}
