package edu.unk.cs406.user.profile.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import edu.unk.cs406.user.profile.dto.CreateProfileDTO;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;



public class CreateUnitTest {
	
	private CreateProfileDTO CDTO;
	private ProfileService service;
	private Validator validations;
	private ProfileRepository repo;
	@Before
	public void createMocks()
	{
		this.repo = Mockito.mock(ProfileRepository.class);
		this.validations = Mockito.mock(Validator.class);
		this.service = new ProfileServiceImpl(this.repo, this.validations);
	}
	
	@Test
	public void testCreateProfileDTO()
	{
		String id = UUID.randomUUID().toString();
		CreateProfileDTO CDTO = null;
		CDTO = new CreateProfileDTO();
		CDTO.setId(id);
		CDTO.setLabel("testCreate");
		CDTO.setEmailID("create@yahoo.com");
		CDTO.setPassword("CReate123!@#");
		
		Set<ConstraintViolation<CreateProfileDTO>> violations = new HashSet<ConstraintViolation<CreateProfileDTO>>();
		Mockito.when(this.validations.validate(CDTO)).thenReturn(violations);
		Mockito.when(this.repo.exists(CDTO.getId())).thenReturn(false);
		Mockito.when(this.repo.save(Mockito.any(ProfileEntity.class))).then(new Answer<ProfileEntity>() {
			
			public ProfileEntity answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
			      return (ProfileEntity) args[0];
			}	
		});
		this.service.CreateUserProfile(CDTO);
		Mockito.verify(this.validations).validate(CDTO);
		Mockito.verify(this.repo).exists(Mockito.anyString());
		Mockito.verify(this.repo).save(Mockito.any(ProfileEntity.class));
		
		
		
	}

	@Test
	public void testProfileIdAlreadyExists() {
		String id = UUID.randomUUID().toString();
		CreateProfileDTO CDTO = null;
		CDTO = new CreateProfileDTO();
		CDTO.setId(id);
		CDTO.setLabel("testCreate");
		CDTO.setEmailID("create@yahoo.com");
		CDTO.setPassword("CReate123!@#");
		
		Set<ConstraintViolation<CreateProfileDTO>> violations = new HashSet<ConstraintViolation<CreateProfileDTO>>();
		Mockito.when(this.validations.validate(CDTO)).thenReturn(violations);
		Mockito.when(this.repo.exists(CDTO.getId())).then(new Answer<Boolean>() {
			private int count = 0;

			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				if(count < 3) {
					count++;
					return true;
				}
				return false;
			}
		});
		ProfileEntity pe = this.service.CreateUserProfile(CDTO);
		Assert.assertNull(pe);
		Mockito.verify(this.validations).validate(CDTO);
		Mockito.verify(this.repo).exists(CDTO.getId());
		
		
	}
}
