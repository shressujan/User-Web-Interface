package edu.unk.cs406.user.profile.service;

import java.util.UUID;

import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;


public class GetUnitTest {
	private ProfileRepository repo;
	private ProfileService service;
	private Validator validations;
	
	@Before
	public void createMocks()
	{
		this.repo = Mockito.mock(ProfileRepository.class);
		this.validations = Mockito.mock(Validator.class);
		this.service =  new ProfileServiceImpl(this.repo, this.validations);
	}
	
	
	@Test
	public void testGetProfileDTOSuccess()
	{
		String id = UUID.randomUUID().toString();
		ProfileEntity pe = new ProfileEntity();
		Mockito.when(this.repo.findOne(id)).thenReturn(pe);
		
		ProfileEntity upe = this.service.GetUserProfile(id);		
		Mockito.verify(this.repo).findOne(id);
		Assert.assertEquals(upe, pe);
	}
	
	@Test
	public void testGetProfileDTOFailure()
	{
		String id = UUID.randomUUID().toString();
		Mockito.when(this.repo.exists(id)).thenReturn(false);
		Mockito.when(this.repo.findOne(id)).thenReturn(null);
		ProfileEntity upe = this.service.GetUserProfile(id);	
		Mockito.verify(this.repo).findOne(id);
		Assert.assertNull(upe);
	}
}
