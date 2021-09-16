package com.example.aopwithmailserviceapp.service;

public interface MovideDbDao {

    String dataRequest();
//    @MailAspect
    boolean addMovie(String title, String release);


}
