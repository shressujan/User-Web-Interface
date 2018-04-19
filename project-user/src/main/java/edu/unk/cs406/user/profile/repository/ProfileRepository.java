package edu.unk.cs406.user.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.unk.cs406.user.entity.UserEntity;


@Repository

public interface ProfileRepository extends MongoRepository<UserEntity, String>, ProfileRepositoryCustom {
	public UserEntity findByLabel(String label);
}
