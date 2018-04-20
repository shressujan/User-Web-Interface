package edu.unk.cs406.user.profile.repository;

import java.util.Objects;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.unk.cs406.user.entity.UserEntity;
import edu.unk.cs406.user.group.entity.GroupEntity;
import edu.unk.cs406.user.profile.entity.ProfileEntity;
import edu.unk.cs406.user.profile.repository.ProfileRepository;


@RunWith(SpringRunner.class)
@DataMongoTest
@AutoConfigureDataMongo
public class UserRepositoryIntegrationTest {

	@Autowired
	ProfileRepository profileRepo;

	private ProfileEntity pE = null;

	//	@Before
	//	public void addToRepository()
	//	{
	//		gE =  new GroupEntity();
	//		gE.setLabel("test");
	//		gE.setDescription("test");	
	//		this.userRepo.save(gE);
	//		
	//		pE =  new ProfileEntity();
	//		pE.setLabel("test1");
	//		pE.setDescription("test1");
	//		pE.addSubscriptions("test1");
	//		
	//		this.userRepo.save(pE);
	//	}

	@After
	public void deleteRepository()
	{
		this.profileRepo.deleteAll();
	}

//	@Test
//	public void testGroupStructure()
//	{
//		gE =  new GroupEntity();
//		gE.setLabel("test");
//		gE.setDescription("test");	
//		this.userRepo.save(gE);
//		UserEntity uE= this.userRepo.findOne(gE.getId()) ;
//		Assert.assertNotNull(uE);
//
//	}
	@Test
	public void testProfileStructure()
	{
		pE =  new ProfileEntity();
		pE.setLabel("test1");
		pE.setEmailID("snoop@yahoo.com");
		pE.setPassword("PAssword123$%");
		pE.setDescription("test1");
		pE.addSubscriptions("test1");
		this.profileRepo.save(pE);
		ProfileEntity uE= this.profileRepo.findOne(pE.getId()) ;
		Assert.assertNotNull(uE);
	}

	@Test
	public void testfindByLabel()
	{
		ProfileEntity pE=  new ProfileEntity();
		pE.setLabel("test2");
		pE.setEmailID("snoop@yahoo.com");
		pE.setPassword("PAssword123$%");
		pE.setDescription("test2");
		pE.addSubscriptions("test2");
		this.profileRepo.save(pE);

		ProfileEntity u1 = Objects.requireNonNull(this.profileRepo.findByLabel("test2"));
		Assert.assertNotNull(u1);

	}

	@Test
	public void testCustomUpdateProfileEntity()
	{
		//Updating profileEntity in the user repository
		ProfileEntity pE=  new ProfileEntity();
		pE.setLabel("test3");
		pE.setEmailID("snoop@yahoo.com");
		pE.setPassword("PAssword123$%");
		pE.setDescription("test3");
		pE.addSubscriptions("test3");
		this.profileRepo.save(pE);

		ProfileEntity uPE = this.profileRepo.findOne(pE.getId());
		uPE.setLabel("test4");
		uPE.setEmailID("snoop_suzan@yahoo.com");
		uPE.setPassword("PAssword123$%");
		uPE.setDescription("test 4");
		
		Assert.assertNotNull(this.profileRepo.updateProfileEntity(uPE));		
		Assert.assertEquals(pE.getId(), uPE.getId());

		ProfileEntity updatedPE = this.profileRepo.findOne(uPE.getId());
		Assert.assertEquals(uPE.getLabel(), updatedPE.getLabel());
		Assert.assertEquals(uPE.getEmailID(), updatedPE.getEmailID());

	}
	
}