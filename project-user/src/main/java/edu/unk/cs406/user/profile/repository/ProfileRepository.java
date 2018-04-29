package edu.unk.cs406.user.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.unk.cs406.user.profile.entity.ProfileEntity;

public interface ProfileRepository extends MongoRepository<ProfileEntity, String>, ProfileRepositoryCustom {
	public ProfileEntity findByLabel(String label);
}
