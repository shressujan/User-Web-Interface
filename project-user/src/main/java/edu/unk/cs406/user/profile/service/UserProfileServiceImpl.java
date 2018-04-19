package edu.unk.cs406.user.profile.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.classic.Logger;
import edu.unk.cs406.user.profile.dto.CreateUserProfileDTO;
import edu.unk.cs406.user.profile.dto.UpdateUserProfileDTO;
import edu.unk.cs406.user.entity.User;
import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;

public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private final ProfileRepository userRepo;
	private CreateUserProfileDTO CDTO;
	private UpdateUserProfileDTO UDTO;
	private final Validator validation;
//	private static final Logger logger ;
	
	public UserProfileServiceImpl (ProfileRepository u, Validator v)
	{
		this.userRepo =  Objects.requireNonNull(u);
		this.validation = Objects.requireNonNull(v);
	}

	
	public User CreateUserProfile(CreateUserProfileDTO dto) {
		// TODO Auto-generated method stub
		
		this.CDTO = Objects.requireNonNull(dto);
		Set<ConstraintViolation<CreateUserProfileDTO>> violations = this.validation.validate(dto, null);
		if(violations.isEmpty())
		{
			ProfileEntity UPE = new ProfileEntity();
			UPE.setLabel(this.CDTO.getLabel());
			UPE.setDescription(this.CDTO.getDescription());
//			UPE.addSubscriptions(this.DTO.getSubscriptions());
//			UPE.addContent(this.DTO.getContent());
			
			
			return this.userRepo.save(UPE);
		
		}
		else
		{
			return null;
		}
	
	}

	@Override
	public UserEntity GetUserProfile(String profileID) {
		// TODO Auto-generated method stub
		UserEntity UPE = Objects.requireNonNull(userRepo.findOne(profileID));
		
		return UPE;
	}

	@Override
	public User FindUserProfileByLabel(String label) {
		// TODO Auto-generated method stub
		UserEntity UPE =  Objects.requireNonNull(this.userRepo.findByLabel(label));
		
		return UPE;
	}

	@Override
	public List<UserEntity> FindAllUserProfiles() {
		// TODO Auto-generated method stub
		return this.userRepo.findAll();
	}

	@Override
	public User UpdateUserProfile(UpdateUserProfileDTO dto) {
		// TODO Auto-generated method stub
		UDTO = Objects.requireNonNull(dto);
		Set<ConstraintViolation<UpdateUserProfileDTO>> violations = this.validation.validate(dto, null);
		if(violations.isEmpty())
		{
			UserEntity UPE = this.userRepo.findOne(dto.getId());
			UPE.setLabel(dto.getLabel());
			UPE.setDescription(dto.getDescription());
			
			return this.userRepo.save(UPE);
		}

		return null;
	}

	@Override
	public User DeleteUserProfile(String profileID) {
		// TODO Auto-generated method stub
		UserEntity UPE = Objects.requireNonNull(this.userRepo.findOne(profileID));
		if(UPE != null)
		{
			this.userRepo.delete(UPE.getId());
			return UPE;
		}
		else
		{
			return null;
		}
	}

}
