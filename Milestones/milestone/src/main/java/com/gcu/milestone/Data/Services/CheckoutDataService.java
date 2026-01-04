package com.gcu.milestone.Data.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.milestone.Data.Entities.CheckoutEntity;
import com.gcu.milestone.Data.Repositories.checkoutRepository;
import com.gcu.milestone.Models.CheckoutModel;

public class CheckoutDataService implements DataAccessInterface{

    @Autowired
    private checkoutRepository checkoutRepository;

    public CheckoutDataService(checkoutRepository checkoutRepository) {
        System.out.println("In checkoutRepository only creator");
        this.checkoutRepository = checkoutRepository;
    }

    public CheckoutDataService() {
        super();
    }

    @Override
    public List findAll() {
        String sql = "SELECT * FROM checkout";
        System.out.println("SQL QUERY: " + sql);
        List<CheckoutEntity> checkout = new ArrayList<>();
        try {

            // Get all of the Entity Orders
            Iterable<CheckoutEntity> checkoutIterable = checkoutRepository.findAll();

            // Convert to a List and return the List
            //checkout = new ArrayList<CheckoutEntity>();
            checkoutIterable.forEach(checkout::add);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return checkout;
    }

    @Override
    public Object findById(Long id) {
       CheckoutEntity Checkout = checkoutRepository.findById(id).get();
       CheckoutModel model = convertFromEntity(Checkout);
       return model;
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean update(CheckoutEntity Checkout) {
        try{
            CheckoutEntity CheckoutCheck = checkoutRepository.save(Checkout);
            if(CheckoutCheck == null) return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public void delete(Long id) {
        checkoutRepository.deleteById(id);
    }

    public boolean create(CheckoutEntity Checkout) {
        String sql = "INSERT INTO Checkout (id, movieId, userId) VALUES(?, ?, ?)";
        System.out.println("~~~ In create method in DataService. SQL QUERY: " + sql);
        try {
        CheckoutEntity CheckoutCheck = checkoutRepository.save(Checkout);
        System.out.println("~~~~~ New Checkout: " + CheckoutCheck.getId());
        if(CheckoutCheck == null) return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    public CheckoutModel convertFromEntity(CheckoutEntity entity){
        int id = Math.toIntExact(entity.getId());
        CheckoutModel Checkout = new CheckoutModel(id, entity.getMovieId(), entity.getUserId());
        return Checkout;
    }

    public CheckoutEntity convertFromModel(CheckoutModel model){
        Long id = (long) model.getId();
        CheckoutEntity Checkout = new CheckoutEntity(id, model.getMovieId(), model.getUserId());
        return Checkout;
    }

}
