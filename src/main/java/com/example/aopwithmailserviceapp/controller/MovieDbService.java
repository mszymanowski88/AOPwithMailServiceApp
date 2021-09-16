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

public List<RequestResult> listOfMovies ;


MovieDbService()
{
listOfMovies = new ArrayList<>();

}
    @EventListener(ApplicationReadyEvent.class)
    public  List<RequestResult> movies()
    {

        RestTemplate restTemplate = new RestTemplate();

        MovieRequest movieRequest = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=9fa5af48946037e925e1a20c951e797d",MovieRequest.class);


        listOfMovies = movieRequest.getResults();

        for(RequestResult movieRequest1 : listOfMovies)
        {

            System.out.println(movieRequest1);
        }

//       for(RequestResult movieRequest1 : movieRequest.getResults())
//       {
//           System.out.println(movieRequest1);
//
//       }
        return listOfMovies;



    }



//   public MovieRequest movies()
//   {
//
//       RestTemplate restTemplate = new RestTemplate();
//
//       MovieRequest movieRequest = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=9fa5af48946037e925e1a20c951e797d",MovieRequest.class);
//
//
//      listOfMovies = movieRequest.getResults();
//
//        for(RequestResult movieRequest1 : listOfMovies)
//        {
//
//            System.out.println(movieRequest1);
//        }
//
////       for(RequestResult movieRequest1 : movieRequest.getResults())
////       {
////           System.out.println(movieRequest1);
////
////       }
//       return movieRequest;
//
//
//
//   }

    @Override
//    @MailAspect
    public boolean addMovie(String title, String release) {

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    RequestResult newMovie = new RequestResult();
    newMovie.setTitle(title);
    newMovie.setReleaseDate(release);

       return  listOfMovies.add(newMovie);


    }


    //@EventListener(ApplicationReadyEvent.class)
//public RequestResult requestResult()
//{
//
//    RestTemplate restTemplate = new RestTemplate();
//    RequestResult requestResult = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=9fa5af48946037e925e1a20c951e797d",RequestResult.class);
//
//    System.out.println("dziala");
//    System.out.println(requestResult.toString());
//            return requestResult;
//
//}


    @Override
    public String dataRequest() {
//        RestTemplate restTemplate = new RestTemplate();
//      RequestResult requestResult = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=9fa5af48946037e925e1a20c951e797d",RequestResult.class);
//
//        RestTemplate restTemplate = new RestTemplate();
//        RequestResult[] requestResult = restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular?api_key=9fa5af48946037e925e1a20c951e797d",RequestResult[].class);
//
//return requestResult.toString();

        return null;

    }
}
