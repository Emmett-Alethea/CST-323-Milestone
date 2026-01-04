package com.gcu.milestone.Data.Services;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.TabbedPaneUI;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.milestone.Data.Entities.MovieEntity;
import com.gcu.milestone.Data.Repositories.movieRepository;
import com.gcu.milestone.Models.movieModel;

public class MovieDataService implements DataAccessInterface {

    @Autowired
    private movieRepository movieRepository;

    public MovieDataService(movieRepository moviesRepository) {
        System.out.println("In movieRepository only creator");
        this.movieRepository = moviesRepository;
    }

    public MovieDataService() {
        super();
    }

    @Override
    public List findAll() {
        String sql = "SELECT * FROM movie";
        System.out.println("SQL QUERY: " + sql);
        List<MovieEntity> movies = new ArrayList<MovieEntity>();
        try {

            // Get all of the Entity Orders
            Iterable<MovieEntity> moviesIterable = movieRepository.findAll();

            // Convert to a List and return the List
            //movies = new ArrayList<MovieEntity>();
            moviesIterable.forEach(movies::add);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Object findById(Long id) {
       MovieEntity movie = movieRepository.findById(id).get();
       movieModel model = convertFromEntity(movie);
       return model;
    }

    @Override
    public Object findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean update(MovieEntity movie) {
        try{
            MovieEntity movieCheck = movieRepository.save(movie);
            if(movieCheck == null) return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public boolean create(MovieEntity movie) {
        String sql = "INSERT INTO movie (id, genre, price, status, title, user_id) VALUES(?, ?, ?, ?, ?, ?)";
        System.out.println("~~~ In create method in DataService. SQL QUERY: " + sql);
        try {
        MovieEntity movieCheck = movieRepository.save(movie);
        System.out.println("~~~~~ New movie: " + movieCheck.getTitle());
        if(movieCheck == null) return false;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return true;
    }

    public movieModel convertFromEntity(MovieEntity entity){
        int id = Math.toIntExact(entity.getId());
        movieModel movie = new movieModel(id, entity.getGenre(), entity.getPrice(), entity.getStatus(), entity.getTitle(), entity.getUserId());
        return movie;
    }

    public MovieEntity convertFromModel(movieModel model){
        Long id = (long) model.getId();
        MovieEntity movie = new MovieEntity(id, model.getGenre(), model.getPrice(), model.getStatus(), model.getTitle(), model.getUserId());
        return movie;
    }
}
