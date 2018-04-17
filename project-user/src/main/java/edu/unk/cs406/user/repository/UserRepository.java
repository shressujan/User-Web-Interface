package edu.unk.cs406.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.unk.cs406.user.entity.UserEntity;


@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>, UserRepositoryCustom {
	public UserEntity findByLabel(String label);
}
