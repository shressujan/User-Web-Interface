package edu.unk.cs406.user.profile.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	ConstructorUnitTest.class,
	CreateUnitTest.class,
	DeleteUnitTest.class,
	FindAllUnitTest.class,
	FindUnitTest.class,
	GetUnitTest.class,
	UpdateUnitTest.class
})
public class UserRepositoryServiceImplTestSuite {
	
}