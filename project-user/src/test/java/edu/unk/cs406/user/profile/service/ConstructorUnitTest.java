package edu.unk.cs406.user.profile.service;

import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import edu.unk.cs406.user.profile.repository.ProfileRepository;

public class ConstructorUnitTest {
	
	@Test
	public void testConstructor()
	{
		Validator validator = Mockito.mock(Validator.class);
		ProfileRepository repo = Mockito.mock(ProfileRepository.class	);
		ProfileServiceImpl service;
		
		try
		{
			service  =  new ProfileServiceImpl(repo, null);
			Assert.fail("Constructor must throw null if the validator is null");
		}
		catch(Exception e)
		{
			Assert.assertTrue(e instanceof NullPointerException);
		}
		
		try
		{
			service  =  new ProfileServiceImpl(null, validator);
			Assert.fail("Constructor must throw null if the ProfileRepository is null");
		}
		catch(Exception e)
		{
			Assert.assertTrue(e instanceof NullPointerException);
		}

		try
		{
			service  =  new ProfileServiceImpl(null, null);
			Assert.fail("Constructor must throw null if the validator and the ProfileRepository are both null");
		}
		catch(Exception e)
		{
			Assert.assertTrue(e instanceof NullPointerException);
		}
		try
		{
			service  =  new ProfileServiceImpl(repo, validator);
			Assert.assertNotNull(service);			
		}
		catch(Exception e)
		{}
	}
}
