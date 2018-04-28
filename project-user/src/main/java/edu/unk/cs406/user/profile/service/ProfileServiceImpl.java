package edu.unk.cs406.user.profile.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import edu.unk.cs406.user.profile.dto.CreateProfileDTO;
import edu.unk.cs406.user.profile.dto.UpdateProfileDTO;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;

@Service
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
		System.err.println(CDTO.getPassword());
		System.err.println(CDTO.getLabel());
		System.err.println(CDTO.getEmailID());
		Set<ConstraintViolation<CreateProfileDTO>> violations = this.validation.validate(CDTO);
		if(violations.isEmpty())
		{
			if(this.userRepo.exists(dto.getId()))
			{
				logger.warn("Id {} already exists", dto.getId());
				return null;
			}
			ProfileEntity UPE = new ProfileEntity();
			UPE.setId(CDTO.getId());
			UPE.setLabel(this.CDTO.getLabel());
			UPE.setDescription(this.CDTO.getDescription());
			UPE.setEmailID(this.CDTO.getEmailID()); 
			UPE.setPassword(this.CDTO.getPassword());
			//			UPE.addSubscriptions(this.DTO.getSubscriptions());
			//			UPE.addContent(this.DTO.getContent());
			logger.info("ProfileEntity with ID {} created", UPE.getId());
			return this.userRepo.save(UPE);

		}
		else
		{
			System.err.println(violations.toString());
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
		UDTO = Objects.requireNonNull(dto,"argument zero must not be null");
		
		Set<ConstraintViolation<UpdateProfileDTO>> violations = this.validation.validate(dto);

		if(violations.size() > 0)
		{
			ConstraintViolationException e = new ConstraintViolationException ("dto is invalid", violations);
			logger.error("Failed to validate {}", dto.getClass().getName(),e);
			throw e;

		}
		else
		{
			ProfileEntity UPE = new ProfileEntity();
			try
			{
				UPE = this.userRepo.findOne(this.UDTO.getId());
				UPE.setLabel(this.UDTO.getLabel());
				UPE.setDescription(this.UDTO.getDescription());
				UPE.setEmailID(this.UDTO.getEmailID());
				UPE.setPassword(this.UDTO.getPassword());
				UPE = this.userRepo.updateProfileEntity(UPE);
				logger.info("ProfileEntity {} with id {} updated", ProfileEntity.class.getName(), UPE.getId() );
				return UPE;
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


	@Override
	public void deleteAll() {
		this.userRepo.deleteAll();
		
	}

}
