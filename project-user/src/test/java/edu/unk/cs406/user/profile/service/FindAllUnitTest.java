package edu.unk.cs406.user.profile.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;

public class FindAllUnitTest {
	
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
	public void FindAllProfilesTestSuccess()
	{
		List<ProfileEntity> pe = new ArrayList<ProfileEntity>();
		Mockito.when(this.repo.findAll()).thenReturn(pe);
		
		List<ProfileEntity> upe = this.service.FindAllUserProfiles();
		Assert.assertSame(pe, upe);
		Mockito.verify(this.repo).findAll();
	}
	
	@Test
	public void FindAllProfilesTestFailure()
	{
		Mockito.when(this.repo.findAll()).thenReturn(null);
		
		List<ProfileEntity> upe = this.service.FindAllUserProfiles();
		Assert.assertNull(upe);
		Mockito.verify(this.repo).findAll();
	}
}
