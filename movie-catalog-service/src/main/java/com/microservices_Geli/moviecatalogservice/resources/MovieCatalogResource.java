package com.microservices_Geli.moviecatalogservice.resources;


import com.microservices_Geli.moviecatalogservice.models.CatalogItem;
import com.microservices_Geli.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    List<Rating> ratings = Arrays.asList(
            new Rating("1234",4),
            new Rating("5678",3)
            );


    //step 1, get all rated movie IDs, hard code ratings for now
    //step 2, for each movie id, call movie info service and get details
    //put them all together

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        return Collections.singletonList(
                new CatalogItem("Transformers", "Transformers action movie",4)
        );
    }
}
