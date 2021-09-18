package com.example.aopwithmailserviceapp.controller;

import com.example.aopwithmailserviceapp.model.MovieRequest;
import com.example.aopwithmailserviceapp.model.RequestResult;
import com.example.aopwithmailserviceapp.service.MovideDbDao;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieDbService implements MovideDbDao {

    public List<RequestResult> listOfMovies;
    public final String key = "9fa5af48946037e925e1a20c951e797d";


    MovieDbService() {
        listOfMovies = new ArrayList<>();

    }

    @EventListener(ApplicationReadyEvent.class)
    public List<RequestResult> movies() {

        RestTemplate restTemplate = new RestTemplate();
        MovieRequest movieRequest = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key="+key, MovieRequest.class);
        listOfMovies = movieRequest.getResults();

        return listOfMovies;


    }

    @Override
    public boolean addMovie(String title, String release) {

        RequestResult newMovie = new RequestResult();
        newMovie.setTitle(title);
        newMovie.setReleaseDate(release);

        return listOfMovies.add(newMovie);


    }
}
