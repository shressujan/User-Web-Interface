package edu.unk.cs406.user.group.service;

import java.util.List;

import edu.unk.cs406.user.entity.User;
import edu.unk.cs406.user.group.dto.CreateGroupDTO;
import edu.unk.cs406.user.group.dto.UpdateGroupDTO;
import edu.unk.cs406.user.group.entity.GroupEntity;

public interface GroupService {
	
	public User create(CreateGroupDTO user);
	
	public User get(String id);
	
	public User find(String username);
	
	public List<GroupEntity> find();
	
	public User update(UpdateGroupDTO updUser);
	
	public boolean delete(String id);
	
}
