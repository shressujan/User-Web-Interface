package edu.unk.cs406.user.profile.service;

import java.util.UUID;

import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;



public class DeleteUnitTest {
	
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
	public void testDeleteProfileDTOSuccess()
	{
		String id = UUID.randomUUID().toString();
		ProfileEntity pe =  new ProfileEntity();
		Mockito.when(this.repo.findOne(id)).thenReturn(pe	);
		
		ProfileEntity upe = this.service.DeleteUserProfile(id);
		Assert.assertSame(pe, upe);
		Mockito.verify(this.repo).findOne(id);
		Mockito.verify(this.repo).delete(pe.getId());
		
	}
	@Test
	public void testDeleteProfileDTOFailure()
	{
		String id = UUID.randomUUID().toString();
		Mockito.when(this.repo.findOne(id)).thenReturn(null);
		
		ProfileEntity pe = this.service.DeleteUserProfile(id);
		Assert.assertNull(pe);
		Mockito.verify(this.repo).findOne(id);
	}
	
	@Test
	public void testDeleteProfileDTOException()
	{
		String id = UUID.randomUUID().toString();
		ProfileEntity pe =  new ProfileEntity();
		Mockito.when(this.repo.findOne(id)).thenReturn(pe);
		Mockito.doThrow(new IllegalArgumentException()).when(this.repo).delete(pe.getId());
		
		ProfileEntity upe = this.service.DeleteUserProfile(id);
		Assert.assertNull(upe);
		Mockito.verify(this.repo).findOne(id);
	}
}
