package edu.unk.cs406.user.group.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.unk.cs406.user.entity.User;
import edu.unk.cs406.user.group.dto.CreateGroupDTO;
import edu.unk.cs406.user.group.dto.UpdateGroupDTO;
import edu.unk.cs406.user.group.entity.GroupEntity;
import edu.unk.cs406.user.repository.UserRepository;

public class GroupServiceImpl implements GroupService {
	private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
	private final UserRepository repository;
	private final Validator validator;
	
	public GroupServiceImpl(UserRepository repository, Validator validator) {
		this.repository = Objects.requireNonNull(repository);
		this.validator = Objects.requireNonNull(validator);
	}
	
	public User create(CreateGroupDTO dto) {
		dto = Objects.requireNonNull(dto);
		
		Set<ConstraintViolation<CreateGroupDTO>> violations = this.validator.validate(dto);
		if(!violations.isEmpty()) {
			logger.error("Constraint Violation {}", dto.getClass().getName());
			throw new ConstraintViolationException(violations);
		}
		
		GroupEntity entity = new GroupEntity();
//		entity.setUsername(dto.getUsername());
//		entity.setPassword(dto.getPassword());
//		entity.setEmail(dto.getEmail());
		
		return this.repository.save(entity);
	}

	public User get(String id) {
		logger.info("getting id {}", id);
		
		User user = this.repository.findOne(id);
		
		if(user == null) {
			logger.warn("Unable to get {} id {} not found", GroupEntity.class.getName(), id);
			return null;
		} else {
			return user;
		}
	}

	public User find(String label) {
		User user = this.repository.findByLabel(label);
		
		if(user == null) {
			logger.warn("Unable to find {} label {} not found", GroupEntity.class.getName(), label);
			return null;
		} else {
			return user;
		}
	}

	public List<GroupEntity> find() {
		//return this.repository.findAll();
		return null;
	}

	public User update(UpdateGroupDTO dto) {
		//validate arguments
		dto = Objects.requireNonNull(dto,"argument zero must not be null");
		Set<ConstraintViolation<UpdateGroupDTO>> violations = this.validator.validate(dto);
		if(violations.size() > 0) {
			ConstraintViolationException e = new ConstraintViolationException("dto is invalid", violations);
			logger.error("Failed to validate {}", CreateGroupDTO.class.getName(), e);
			throw e;
		}
		
		//find entity
		GroupEntity entity;
		try {
			entity = (GroupEntity) Objects.requireNonNull(this.repository.findOne(dto.getId()));
		} catch(NullPointerException e) {
			logger.error("unable to update {} id {} does not exist", GroupEntity.class.getName(), dto.getId(), e);
			return null;
		}
		
//		if(dto.getUsername() != null) {
//			entity.setUsername(dto.getUsername());
//		}
//		if(dto.getPassword() != null) {
//			entity.setPassword(dto.getPassword());
//		}
//		if(dto.getEmail() != null) {
//			entity.setEmail(dto.getEmail());
//		}
		
		//Save Changes
		entity = this.repository.save(entity);
		
		logger.info("Updated {} id {}", GroupEntity.class.getName(), entity.getId());
		
		return entity;
	}

	public boolean delete(String id) {
		User user = this.repository.findOne(id);
		
		if(user == null) {
			logger.warn("Unable to delete {} id {} not found", GroupEntity.class.getName(), id);
			return false;
		} else {
			try {
				this.repository.delete(id);
				logger.info("deleted {} id {}", GroupEntity.class.getName(), id);
				return true;
			} catch(Exception e) {
				logger.error("Unable to delete {} id {}", GroupEntity.class.getName(), id, e);
			}
		}
		return false;
	}
}
