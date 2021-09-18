package com.example.aopwithmailserviceapp.controller;

import com.example.aopwithmailserviceapp.apect.MailAspect;
import com.example.aopwithmailserviceapp.model.RequestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MovieDbController {


    private final MovieDbService movieDbService;
    private final List<RequestResult> movieList;


    @Autowired
    MovieDbController(MovieDbService movieDbService) {
        this.movieDbService = movieDbService;
        movieList = movieDbService.listOfMovies;

    }


    @GetMapping("/movies")
    public String getMovieList(Model model) {

        model.addAttribute("movieList", movieDbService.listOfMovies);
        model.addAttribute("addMovie", new RequestResult());

        return "movies";

    }


    @MailAspect
    @PostMapping("/movies")
    public String addMovie(@ModelAttribute RequestResult requestResult) {

        movieDbService.listOfMovies.add(requestResult);

        return "redirect:/movies";
    }

    @GetMapping("/error")
    public String incorrectUserInput(Model model) {

        return "error";
    }


}
