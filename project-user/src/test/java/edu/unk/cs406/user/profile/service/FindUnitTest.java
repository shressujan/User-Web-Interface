package edu.unk.cs406.user.profile.service;

import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;

public class FindUnitTest {
	
	private ProfileRepository repo;
	private Validator violations;
	private ProfileService service;
	
	@Before
	public void createMocks()
	{
		this.repo = Mockito.mock(ProfileRepository.class);
		this.violations = Mockito.mock(Validator.class);
		this.service = new ProfileServiceImpl(this.repo, this.violations);
	}
	
	@Test
	public void FindUserProfileByLabelTestSuccess()
	{
		String label = "test";
		ProfileEntity pe = new ProfileEntity();
		Mockito.when(this.repo.findByLabel(label)).thenReturn(pe);
		
		ProfileEntity upe = this.service.FindUserProfileByLabel(label);
		Mockito.verify(this.repo).findByLabel(label);
		Assert.assertSame(pe, upe);
	
	}
	
	@Test
	public void FindUserProfileByLabelTestFailure()
	{
		String label = "test";
		Mockito.when(this.repo.findByLabel(label)).thenReturn(null);
		
		ProfileEntity pe = this.service.FindUserProfileByLabel(label);
		Mockito.verify(this.repo).findByLabel(label);
		Assert.assertNull(pe);
	}
}
