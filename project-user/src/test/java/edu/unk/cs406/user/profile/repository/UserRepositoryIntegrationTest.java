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

	private GroupEntity gE = null;

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
		pE.setDescription("test1");
		pE.addSubscriptions("test1");
		this.profileRepo.save(pE);
		UserEntity uE= this.profileRepo.findOne(pE.getId()) ;
		Assert.assertNotNull(uE);
	}

	@Test
	public void testfindByLabel()
	{
		UserEntity uE=  new UserEntity();
		uE.setLabel("test5");
		uE.setDescription("test5");
		this.profileRepo.save(uE);

		UserEntity u1 = Objects.requireNonNull(this.profileRepo.findByLabel("test5"));
		Assert.assertNotNull(u1);

	}

	@Test
	public void testCustomUpdateUserEntityProfile()
	{
		//Updating profileEntity in the user repository
		UserEntity pE=  new ProfileEntity();
		pE.setLabel("test3");
		pE.setDescription("test3");
		this.profileRepo.save(pE);

		UserEntity uPE = this.profileRepo.findOne(pE.getId());
		uPE.setLabel("test4");
		uPE.setDescription("test 4");	
		Assert.assertNotNull(this.profileRepo.updateUserEntity(uPE));		
		Assert.assertEquals(pE.getId(), uPE.getId());

		UserEntity updatedPE = this.profileRepo.findOne(uPE.getId());
		Assert.assertEquals(uPE.getLabel(), updatedPE.getLabel());

	}
	
//	@Test
//	public void testCustomUpdateUserEntityGroup()
//	{
//
//		//Updating GroupEntity in the user repository
//		UserEntity gE=  new GroupEntity();
//		gE.setLabel("test6");
//		gE.setDescription("test6");
//		this.userRepo.save(gE);
//
//		UserEntity uGE = this.userRepo.findOne(gE.getId());
//		uGE.setLabel("test7");
//		uGE.setDescription("test 7");	
//		Assert.assertNotNull(this.userRepo.updateUserEntity(uGE));		
//		Assert.assertEquals(gE.getId(), uGE.getId());
//		
//		UserEntity updatedGE = this.userRepo.findOne(uGE.getId());
//		Assert.assertEquals(uGE.getLabel(), updatedGE.getLabel());
//	}
}