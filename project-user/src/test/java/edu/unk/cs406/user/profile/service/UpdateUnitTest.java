package edu.unk.cs406.user.profile.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import edu.unk.cs406.user.profile.dto.UpdateProfileDTO;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;

public class UpdateUnitTest {
	
	private ProfileRepository repo;
	private Validator validations;
	private ProfileService service;
	
	@Before
	public void createMocks()
	{
		this.repo = Mockito.mock(ProfileRepository.class);
		this.validations = Mockito.mock(Validator.class);
		this.service =  new ProfileServiceImpl(this.repo, this.validations);
	}
	
	@Test
	public void testUpdateProfileDTOTestSuccess()
	{
		String id = UUID.randomUUID().toString();
		UpdateProfileDTO dto =  new UpdateProfileDTO();
		dto.setId(id);
		dto.setLabel("update Test");
		dto.setEmailID("update@yahoo.com");
		dto.setPassword("UPdate123@#!#");
		
		ProfileEntity pe =  new ProfileEntity();
		pe.setId(id);
		pe.setLabel("original");
		pe.setEmailID("original@yahoo.com");
		pe.setPassword("ORiginal12!@");
		
		Set<ConstraintViolation<UpdateProfileDTO>> violations = new HashSet<ConstraintViolation<UpdateProfileDTO>>();
		Mockito.when(this.validations.validate(dto)).thenReturn(violations);
		Mockito.when(this.repo.findOne(dto.getId())).thenReturn(pe);
		Mockito.when(this.repo.updateProfileEntity(pe)).then(new Answer<ProfileEntity>() {		
			public ProfileEntity answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
			      return (ProfileEntity) args[0];
			}
			
		});
		
		ProfileEntity upe = this.service.UpdateUserProfile(dto);
		Assert.assertNotNull(upe);
		Mockito.verify(this.validations).validate(dto);
		Mockito.verify(this.repo).findOne(dto.getId());
		Mockito.verify(this.repo).updateProfileEntity(Mockito.any(ProfileEntity.class));
	}
	
	@Test
	public void testUpdateProfileDTOTestFailure()
	{
		UpdateProfileDTO dto = new UpdateProfileDTO();
		Set<ConstraintViolation<UpdateProfileDTO>> violations = new HashSet<ConstraintViolation<UpdateProfileDTO>>();
		Mockito.when(this.validations.validate(dto)).thenReturn(violations);
		Mockito.when(this.repo.findOne(Mockito.anyString())).thenReturn(null);
		

		ProfileEntity upe = this.service.UpdateUserProfile(dto);
		Assert.assertNull(upe);
		Mockito.verify(this.validations).validate(dto);
		Mockito.verify(this.repo).findOne(Mockito.anyString());
	}
	
	@Test
	public void testInvalidUpdateProfileDTOTest()
	{
		UpdateProfileDTO dto =  new UpdateProfileDTO();
		Set<ConstraintViolation<UpdateProfileDTO>> violations = new HashSet<ConstraintViolation<UpdateProfileDTO>>();
		@SuppressWarnings("unchecked")
		ConstraintViolation<UpdateProfileDTO> violation = (ConstraintViolation<UpdateProfileDTO>)Mockito.mock(ConstraintViolation.class);
		violations.add(violation);
		Mockito.when(this.validations.validate(dto)).thenReturn(violations);
		try {
			this.service.UpdateUserProfile(dto);
			Assert.fail("Update must throw an exception when passed an invalid argument");
		} catch(Exception e) {
			Assert.assertTrue("Update must throw ConstraintViolationException when dto is invalid", e instanceof ConstraintViolationException);
			
			Mockito.verify(this.validations).validate(dto);
			
			ConstraintViolationException castE = (ConstraintViolationException) e;
			Assert.assertSame("ConstraintViolationException must contain violations", violation, castE.getConstraintViolations().iterator().next());			
		}
	}
}
