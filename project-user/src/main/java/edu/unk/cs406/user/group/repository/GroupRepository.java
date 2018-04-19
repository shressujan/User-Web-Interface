package edu.unk.cs406.user.group.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.unk.cs406.user.entity.UserEntity;


@Repository
public interface GroupRepository extends MongoRepository<UserEntity, String>, GroupRepositoryCustom {
	public UserEntity findByLabel(String label);
}
