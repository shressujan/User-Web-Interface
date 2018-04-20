package edu.unk.cs406.user.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.unk.cs406.user.profile.dto.CreateProfileDTO;
import edu.unk.cs406.user.profile.dto.UpdateProfileDTO;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.entity.User;
import edu.unk.cs406.user.entity.UserEntity;

@Service
public interface ProfileService {

	public ProfileEntity CreateUserProfile(CreateProfileDTO dto);
	public ProfileEntity GetUserProfile (String profileID);
	public ProfileEntity FindUserProfileByLabel(String label);
	public List<ProfileEntity> FindAllUserProfiles();
	public ProfileEntity UpdateUserProfile(UpdateProfileDTO dto);
	public ProfileEntity DeleteUserProfile(String profileID);  
}
