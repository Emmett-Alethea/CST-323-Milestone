package com.gcu.milestone.Models;

import org.springframework.data.annotation.Id;

public class movieModel {

    @Id
    private int id;

    private String genre; //VarChar in database
    private Float price; //Decimal in database
    private String status; //varchar in database
    private String title; //varchar
    private int userId; //int current_user_id in database, can be null

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String getGenre(){return this.genre;}
    public void setGenre(String genre){this.genre = genre;}

    public Float getPrice(){return this.price;}
    public void setPrice(Float price){this.price = price;}

    public String getStatus(){return this.status;}
    public void setStatus(String status){this.status = status;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public int getUserId(){return this.userId;}
    public void setUserId(int userId){this.userId = userId;}

    public movieModel(){

    }
    public movieModel(int id, String genre, Float price, String status, String title, int userId){
        this.id = id;
        this.genre = genre;
        this.price = price;
        this.status = status;
        this.title = title;
        this.userId = userId;
    }

    
}
