package edu.unk.cs406.user.group.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.unk.cs406.user.group.entity.GroupEntity;

public interface GroupRepository extends MongoRepository<GroupEntity, String>, GroupRepositoryCustom {
	
	List<GroupEntity> findByLabelOrderById(String label);
}
