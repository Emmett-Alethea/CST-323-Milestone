package com.gcu.milestone.Data.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.milestone.Data.Entities.UserEntity;
import com.gcu.milestone.Data.Repositories.userRepository;
import com.gcu.milestone.Models.UserModel;

public class UserDataService implements DataAccessInterface {
    
    @Autowired
    private userRepository userRepository;

    public UserDataService(userRepository userRepository) {
        System.out.println("In UserRepository only creator");
        this.userRepository = userRepository;
    }

    public UserDataService() {
        super();
    }

    @Override
    public List findAll() {
        var sql = "SELECT * FROM users";
        System.out.println("SQL QUERY: " + sql);
        List<UserEntity> Users = new ArrayList<>();
        try {

            // Get all of the Entity Orders
            var UsersIterable = userRepository.findAll();

            // Convert to a List and return the List
            //Users = new ArrayList<UserEntity>();
            UsersIterable.forEach(Users::add);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Users;
    }

    @Override
    public Object findById(Long id) {
       UserEntity User = userRepository.findById(id).get();
       UserModel model = convertFromEntity(User);
       return model;
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean update(UserEntity User) {
        try{
            UserEntity UserCheck = userRepository.save(User);
            if(UserCheck == null) return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public boolean create(UserEntity User) {
        String sql = "INSERT INTO User (id, username, password, name) VALUES(?, ?, ?, ?)";
        System.out.println("~~~ In create method in DataService. SQL QUERY: " + sql);
        try {
        UserEntity UserCheck = userRepository.save(User);
        System.out.println("~~~~~ New User: " + UserCheck.getUsername());
        if(UserCheck == null) return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    public UserModel convertFromEntity(UserEntity entity){
        int id = Math.toIntExact(entity.getId());
        UserModel User = new UserModel(id, entity.getUsername(), entity.getPassword(), entity.getName());
        return User;
    }

    public UserEntity convertFromModel(UserModel model){
        Long id = (long) model.getId();
        UserEntity User = new UserEntity(id, model.getUsername(), model.getPassword(), model.getName());
        return User;
    }
}
