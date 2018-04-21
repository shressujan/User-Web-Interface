package edu.unk.cs406.user.profile.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.unk.cs406.user.profile.dto.CreateProfileDTO;
import edu.unk.cs406.user.profile.dto.UpdateProfileDTO;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;

public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private final ProfileRepository userRepo;
	private CreateProfileDTO CDTO;
	private UpdateProfileDTO UDTO;
	private final Validator validation;
	private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

	public ProfileServiceImpl (ProfileRepository u, Validator v)
	{
		this.userRepo =  Objects.requireNonNull(u);
		this.validation = Objects.requireNonNull(v);
	}


	public ProfileEntity CreateUserProfile(CreateProfileDTO dto) {
		// TODO Auto-generated method stub

		this.CDTO = Objects.requireNonNull(dto);
		Set<ConstraintViolation<CreateProfileDTO>> violations = this.validation.validate(dto, null);
		if(violations.isEmpty())
		{
			ProfileEntity UPE = new ProfileEntity();
			UPE.setLabel(this.CDTO.getLabel());
			UPE.setDescription(this.CDTO.getDescription());
			UPE.setEmailID(this.CDTO.getEmailID());
			UPE.setPassword(this.CDTO.getPassword());
			//			UPE.addSubscriptions(this.DTO.getSubscriptions());
			//			UPE.addContent(this.DTO.getContent());
			return this.userRepo.save(UPE);

		}
		else
		{
			logger.error("Constraint Violation {}", dto.getClass().getName());
			throw new ConstraintViolationException(violations);

		}

	}

	@Override
	public ProfileEntity GetUserProfile(String profileID) {
		// TODO Auto-generated method stub
		logger.info("Getting id {}", profileID);
		ProfileEntity UPE = this.userRepo.findOne(profileID);
		
		if(UPE == null)
		{
			logger.error("Unable to get {} id {} not found",ProfileEntity.class.getName(), profileID );
			return null;
		}

		return UPE;
	}

	@Override
	public ProfileEntity FindUserProfileByLabel(String label) {
		// TODO Auto-generated method stub
		logger.info("Getting label {}", label);
		ProfileEntity  UPE =  this.userRepo.findByLabel(label);
		if(UPE == null)
		{
			logger.error("Unable to get {} label {} not found", ProfileEntity.class.getName(), label );
			return null;
		}

		return UPE;
	}

	@Override
	public List<ProfileEntity> FindAllUserProfiles() {
		// TODO Auto-generated method stub
		try {
			return this.userRepo.findAll();
		} catch (NullPointerException e) {
			logger.error("Unable to get profiles from {}", this.userRepo.getClass().getName() );
			return null;
		}
	}

	@Override
	public ProfileEntity UpdateUserProfile(UpdateProfileDTO dto) {
		// TODO Auto-generated method stub
		UDTO = Objects.requireNonNull(dto);
		Set<ConstraintViolation<UpdateProfileDTO>> violations = this.validation.validate(dto, null);

		if(violations.size() > 0)
		{
			ConstraintViolationException e = new ConstraintViolationException ("dto is valid", violations);
			logger.error("Failed to validate {}", dto.getClass().getName(),e);
			throw e;

		}
		else
		{
			ProfileEntity UPE = null;
			try
			{
				UPE = this.userRepo.findOne(this.UDTO.getId());
				UPE.setLabel(this.UDTO.getLabel());
				UPE.setDescription(this.UDTO.getDescription());
				UPE.setEmailID(this.UDTO.getEmailID());
				UPE.setPassword(this.UDTO.getPassword());
				logger.info("ProfileEntity {} with id {} updated", ProfileEntity.class.getName(), UPE.getId() );
				return this.userRepo.updateProfileEntity(UPE);
			}
			catch (Exception e)
			{
				logger.error("Unable to update ProfileEntity {} with id {} !!", ProfileEntity.class.getName(), dto.getId() );
			}

			return null;
		}
	}

	@Override
	public ProfileEntity DeleteUserProfile(String profileID) {
		// TODO Auto-generated method stub
		ProfileEntity UPE  = this.userRepo.findOne(profileID);
		if(UPE == null)
		{
			logger.warn("Unable to delete ProfileEntity {} with the id {} !!!", ProfileEntity.class.getName(), profileID);
			return null;	
		}
		else
		{
			try
			{
				this.userRepo.delete(UPE.getId());
				logger.info("ProfileEntity {} with id {} deleted!", ProfileEntity.class.getName(), profileID);
				return UPE;
			}
			catch (IllegalArgumentException e)
			{
				logger.error("Unable to delete ProfileEntity {} with the id {} !!!", ProfileEntity.class.getName(), profileID, e);
				return null;
			}
		}
	}

}
