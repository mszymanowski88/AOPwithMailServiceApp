package com.example.aopwithmailserviceapp.controller;

import com.example.aopwithmailserviceapp.mailService.MailAspect;
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


    private MovieDbService movieDbService;
    private List<RequestResult> movieList;
    String title = "ss";
    String release = "ff";



    @Autowired

    MovieDbController(MovieDbService movieDbService)
    {

        this.movieDbService = movieDbService;
        movieList = movieDbService.listOfMovies;



    }



    @GetMapping("/movies")
    public String getMovieList(Model model)
    {

    model.addAttribute("movieList",movieDbService.listOfMovies);


    model.addAttribute("addMovie",new RequestResult());

    return "movies";
    }



    @MailAspect
    @PostMapping("/movies")
    public String addMovie(@ModelAttribute RequestResult requestResult)
    {

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//

            movieDbService.listOfMovies.add(requestResult);
            for(RequestResult requestResult2 : movieDbService.listOfMovies)
            {

                System.out.println("XX");
                System.out.println(requestResult2);
            }

//


        return "redirect:/movies";
}



//    @Before("@annotation(MailAspect)")
//    public void test()
//    {
//        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//
//
//    }

}
