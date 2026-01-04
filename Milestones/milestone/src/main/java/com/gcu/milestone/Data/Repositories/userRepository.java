package com.gcu.milestone.Data.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.gcu.milestone.Data.Entities.UserEntity;

public interface userRepository extends CrudRepository<UserEntity, Long> {
    
}
