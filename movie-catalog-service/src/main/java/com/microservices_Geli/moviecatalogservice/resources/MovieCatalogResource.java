package com.microservices_Geli.moviecatalogservice.resources;


import com.microservices_Geli.moviecatalogservice.models.CatalogItem;
import com.microservices_Geli.moviecatalogservice.models.Movie;
import com.microservices_Geli.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    //step 1, get all rated movie IDs, hard code ratings for now
    //step 2, for each movie id, call movie info service and get details

    //put them all together

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
//        System.out.println("inside getCatalog function");
        RestTemplate restTemplate = new RestTemplate();

        List<Rating> ratings = Arrays.asList(
                new Rating("1234",4),
                new Rating("5678",3)
        );

        return ratings.stream().map(rating ->{
            //make call for rating datas service
            Movie movie = restTemplate.getForObject("http://localhost:8085/movies/"+rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Transformers action movie",rating.getRating());

        }).collect(Collectors.toList());
    }
}
