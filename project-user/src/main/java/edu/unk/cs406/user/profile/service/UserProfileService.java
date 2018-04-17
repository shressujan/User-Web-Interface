package edu.unk.cs406.user.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.unk.cs406.user.profile.dto.CreateUserProfileDTO;
import edu.unk.cs406.user.profile.dto.UpdateUserProfileDTO;
import edu.unk.cs406.user.entity.User;
import edu.unk.cs406.user.profile.entity.ProfileEntity;

@Service
public interface UserProfileService {

	public User CreateUserProfile(CreateUserProfileDTO dto);
	public Optional<ProfileEntity> GetUserProfile (String profileID);
	public User FindUserProfileByLabel(String label);
	public List<ProfileEntity> FindAllUserProfiles();
	public User UpdateUserProfile(UpdateUserProfileDTO dto);
	public User DeleteUserProfile(String profileID);
}
