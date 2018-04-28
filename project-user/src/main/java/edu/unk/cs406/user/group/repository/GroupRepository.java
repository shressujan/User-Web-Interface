package edu.unk.cs406.user.group.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.unk.cs406.user.group.entity.GroupEntity;

@Repository
public interface GroupRepository extends MongoRepository<GroupEntity, String>, GroupRepositoryCustom {
	public GroupEntity findByLabel(String label);
}
