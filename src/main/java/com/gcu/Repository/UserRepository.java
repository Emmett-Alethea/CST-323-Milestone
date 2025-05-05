package com.gcu.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>
{
    public List<UserModel> findAll();

    public void deleteById(Long id);
}
