package edu.unk.cs406.user.group.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.mongodb.WriteResult;

import edu.unk.cs406.user.group.entity.GroupEntity;

public class GroupRepositoryImpl implements GroupRepositoryCustom {
	@Autowired
    MongoTemplate mongoTemplate;

	public GroupEntity updateUserEntity(GroupEntity entity) {
		Query query = new Query(Criteria.where("id").is(entity.getId()));
		Update update = new Update();
                
        WriteResult result = mongoTemplate.updateFirst(query, update, GroupEntity.class);
		
        if(result!=null) {
        	return entity;
        } else {
        	return null;
        }		
	}

}